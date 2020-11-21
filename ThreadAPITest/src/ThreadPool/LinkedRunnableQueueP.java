package ThreadPool;

import java.util.LinkedList;

public class LinkedRunnableQueueP implements RunnableQueueP{
	//任务队列最大容量
	private final int maxSize;
	//拒绝策略
	private final DenyPolicyP denyPolicyP;
	//任务队列
	private final LinkedList<Runnable> runList = new LinkedList<Runnable>();
	
	private final ThreadPoolP threadPoolP;
	
	
	public LinkedRunnableQueueP(int maxSize, DenyPolicyP denyPolicyP, ThreadPoolP threadPoolP) {
		this.maxSize = maxSize;
		this.denyPolicyP = denyPolicyP;
		this.threadPoolP = threadPoolP;
	}
	

	@Override
	public void offer(Runnable runnable) {
		synchronized (runList) {
			if(runList.size()>=maxSize) {
				//任务队列满，执行拒绝策略
				System.out.println(Thread.currentThread().getName()+" 队列满执行拒绝策略 "+  threadPoolP.getQueueSize());
				denyPolicyP.reject(runnable, threadPoolP);
			}else {
				//将任务队列添加到队尾，并且唤醒线程
				runList.addLast(runnable);
				runList.notifyAll();
			}
		}
	}

	@Override
	public Runnable task() throws InterruptedException{
		synchronized (runList) {
			while(runList.isEmpty()) {
				try {
					//任务队列为空则将线程挂起
					runList.wait();
				} catch (InterruptedException e) {
					throw e;
				}
			}
			//从队列头部移除一个任务
			return runList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized (runList) {
			return runList.size();
		}
	}

}
