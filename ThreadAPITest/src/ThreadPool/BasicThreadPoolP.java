package ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadPoolP extends Thread implements ThreadPoolP{

	//初始化线程数量
	private final int initSize;
	//线程池最大线程数量
	private final int maxSize;
	//核心线程数
	private final int coreSize;
	//活跃线程数
	private int activeCount;
	//线程工厂
	private final ThreadFactoryP threadFactory;
	//任务队列
	private final RunnableQueueP runnableQueue;
	//线程是否被关闭
	private volatile boolean isShutdown = false;
	//工作线程队列
	private final Queue<ThreadTask> threadQueue = new ArrayDeque<ThreadTask>();
	//默认拒绝策略
	private final static DenyPolicyP DEFAULT_DENY_POLICYP = new DenyPolicyP.DiscardDenyPolicyP();
	//默认线程工厂
	private final static ThreadFactoryP DEFAULT_THREAD_FACTORY = new DefualThreadFactory();
	//线程空闲时间
	private final long keepAliveTime;
	//时间单位
	private final TimeUnit timeUnit;
	//线程空闲时间后销毁线程池 （队列无任务时间）
	private final long destoryTime;
	//默认销毁时间
	private final static long DESTORY_TIME =  300000;
	public BasicThreadPoolP(int initSize, int maxSize, int coreSize, int queueSize ) {
		this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,queueSize,
				DEFAULT_DENY_POLICYP,10,TimeUnit.SECONDS,DESTORY_TIME);
	}
	
	public BasicThreadPoolP(int initSize, int maxSize, int coreSize, int queueSize ,DenyPolicyP denyPolicyP) {
		this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,queueSize,
				denyPolicyP,10,TimeUnit.SECONDS,DESTORY_TIME);
	}
	
	public BasicThreadPoolP(int initSize, int maxSize, int coreSize, int queueSize ,long destoryTime) {
		this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,queueSize,
				DEFAULT_DENY_POLICYP,10,TimeUnit.SECONDS,destoryTime);
	}
	public BasicThreadPoolP(int initSize, int maxSize, int coreSize, ThreadFactoryP threadFactory,
			int queueSize, DenyPolicyP denyPolicyP,long keepAliveTime, TimeUnit timeUnit,long destoryTime) {
		this.initSize = initSize;
		this.maxSize = maxSize;
		this.coreSize = coreSize;
		this.threadFactory = threadFactory;
		this.runnableQueue = new LinkedRunnableQueueP(queueSize, denyPolicyP, this);
		this.keepAliveTime = keepAliveTime;
		this.timeUnit = timeUnit;
		this.destoryTime=destoryTime;
		this.init();
	}
	private void init() {
		start();
		for(int i=0;i<initSize;i++) {
			newThread();
		}
	}
	private void newThread() {
		InternalTaskP internalTaskP = new InternalTaskP(runnableQueue);
		Thread thread = this.threadFactory.createThread(internalTaskP);
		ThreadTask threadTask = new ThreadTask(thread, internalTaskP);
		threadQueue.offer(threadTask);
		this.activeCount++;
		thread.start();
	}
	
	private void removeThread() {
		ThreadTask threadTask = threadQueue.remove();
		threadTask.internalTaskP.stop();
		this.activeCount--;
	}
	@Override
	public void run() {
		//用于维护线程数量，扩容，回收等工作
		while(!isShutdown && !isInterrupted()) {
			try {
				timeUnit.sleep(keepAliveTime);
			} catch (InterruptedException e) {
				isShutdown=true;
				break;
			}
			synchronized (this) {
				if(isShutdown) {
					break;
				}
				//当前队列中有任务未处理，并且activeCount<coreSize则扩容
				if(runnableQueue.size()>0&&activeCount<coreSize) {
					for(int i=initSize;i<coreSize;i++) {
						System.out.println("activeCount<coreSize则扩容");
						newThread();
					}
					//不想让线程的扩容直接到最大
					continue;
				}
				//当前队列中有任务未处理，并且activeCount<maxSize则继续扩容
				if(runnableQueue.size()>0&&activeCount<maxSize) {
					for(int i=coreSize;i<maxSize;i++) {
						System.out.println("activeCount<maxSize则继续扩容");
						newThread();
					}
				}
				
				//当前队列中没有任务，则需要回收到coreSize
				if(runnableQueue.size()==0&&activeCount>coreSize) {
					for(int i=coreSize;i<activeCount;i++) {
						System.out.println("当前队列中没有任务，则需要回收到coreSize");
						removeThread();
					}
				}
				//当前队列中没有任务，进入休眠
//				if(runnableQueue.size()==0&&activeCount==coreSize) {
//					try {
//						System.out.println("当前队列中没有任务休眠 "+destoryTime);
//						timeUnit.sleep(destoryTime);
//						//休眠后队列任然为空
//						if(runnableQueue.size()==0&&activeCount==coreSize) {
//							System.out.println("当前队列中没有任务销毁");
//							shutdown();
//							break;
//						}
//					} catch (InterruptedException e) {
//						System.out.println("当前队列中没有任务，进入休眠被中断 后销毁");
//						shutdown();
//						break;
//					}
//				}
			}
		}
	}
	
	@Override
	public void execute(Runnable runnable) {
		if(this.isShutdown) {
			throw new  IllegalStateException("Thread pool destory");
		}
		this.runnableQueue.offer(runnable);
	}


	@Override
	public void shutdown() {
		synchronized (this) {
			if(isShutdown) {
				return ;
			}else {
				isShutdown = true;
				threadQueue.forEach(threadTask->{
					threadTask.internalTaskP.stop();
					threadTask.thread.interrupt();
				});
				this.interrupt();
				System.out.println("线程此销毁完毕");
			}
		}
	}

	@Override
	public int getInitSize() {
		if(this.isShutdown) {
			throw new  IllegalStateException("Thread pool destory");
		}
		return this.initSize;
	}

	@Override
	public int getMaxSize() {
		if(this.isShutdown) {
			throw new  IllegalStateException("Thread pool destory");
		}
		return this.maxSize;
	}

	@Override
	public int getCoreSize() {
		if(this.isShutdown) {
			throw new  IllegalStateException("Thread pool destory");
		}
		return this.coreSize;
	}

	@Override
	public int getQueueSize() {
		if(this.isShutdown) {
			throw new  IllegalStateException("Thread pool destory");
		}
		return this.runnableQueue.size();
	}

	@Override
	public int getActiveCount() {
		synchronized (this) {
			return this.activeCount;
		}
	}

	@Override
	public boolean isShutdown() {
		return this.isShutdown;
	}
	
	private static class DefualThreadFactory implements ThreadFactoryP{
		private static final AtomicInteger GROPU_COUNTER = new AtomicInteger();
		private static final ThreadGroup group = 
				new ThreadGroup("my_thread_pool-"+GROPU_COUNTER.getAndDecrement());
		private static final AtomicInteger COUNTER = new AtomicInteger(0);
		@Override
		public Thread createThread(Runnable runnable) {
			return new Thread(group,runnable,"thread-pool-p"+COUNTER.getAndDecrement());
		}
		
	}
	private static class ThreadTask{
		Thread thread;
		InternalTaskP internalTaskP;
		public ThreadTask(Thread thread,InternalTaskP internalTaskP) {
			this.thread =thread;
			this.internalTaskP = internalTaskP;
		}
	}
}
