package ThreadPool;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicThreadPoolP extends Thread implements ThreadPoolP{

	//��ʼ���߳�����
	private final int initSize;
	//�̳߳�����߳�����
	private final int maxSize;
	//�����߳���
	private final int coreSize;
	//��Ծ�߳���
	private int activeCount;
	//�̹߳���
	private final ThreadFactoryP threadFactory;
	//�������
	private final RunnableQueueP runnableQueue;
	//�߳��Ƿ񱻹ر�
	private volatile boolean isShutdown = false;
	//�����̶߳���
	private final Queue<ThreadTask> threadQueue = new ArrayDeque<ThreadTask>();
	//Ĭ�Ͼܾ�����
	private final static DenyPolicyP DEFAULT_DENY_POLICYP = new DenyPolicyP.DiscardDenyPolicyP();
	//Ĭ���̹߳���
	private final static ThreadFactoryP DEFAULT_THREAD_FACTORY = new DefualThreadFactory();
	//�߳̿���ʱ��
	private final long keepAliveTime;
	//ʱ�䵥λ
	private final TimeUnit timeUnit;
	//�߳̿���ʱ��������̳߳� ������������ʱ�䣩
	private final long destoryTime;
	//Ĭ������ʱ��
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
		//����ά���߳����������ݣ����յȹ���
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
				//��ǰ������������δ��������activeCount<coreSize������
				if(runnableQueue.size()>0&&activeCount<coreSize) {
					for(int i=initSize;i<coreSize;i++) {
						System.out.println("activeCount<coreSize������");
						newThread();
					}
					//�������̵߳�����ֱ�ӵ����
					continue;
				}
				//��ǰ������������δ��������activeCount<maxSize���������
				if(runnableQueue.size()>0&&activeCount<maxSize) {
					for(int i=coreSize;i<maxSize;i++) {
						System.out.println("activeCount<maxSize���������");
						newThread();
					}
				}
				
				//��ǰ������û����������Ҫ���յ�coreSize
				if(runnableQueue.size()==0&&activeCount>coreSize) {
					for(int i=coreSize;i<activeCount;i++) {
						System.out.println("��ǰ������û����������Ҫ���յ�coreSize");
						removeThread();
					}
				}
				//��ǰ������û�����񣬽�������
//				if(runnableQueue.size()==0&&activeCount==coreSize) {
//					try {
//						System.out.println("��ǰ������û���������� "+destoryTime);
//						timeUnit.sleep(destoryTime);
//						//���ߺ������ȻΪ��
//						if(runnableQueue.size()==0&&activeCount==coreSize) {
//							System.out.println("��ǰ������û����������");
//							shutdown();
//							break;
//						}
//					} catch (InterruptedException e) {
//						System.out.println("��ǰ������û�����񣬽������߱��ж� ������");
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
				System.out.println("�̴߳��������");
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
