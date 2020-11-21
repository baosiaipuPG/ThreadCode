package ThreadPool;

public class InternalTaskP implements Runnable{
	private final RunnableQueueP runnableQueueP;
	private volatile boolean running =true;
	
	public InternalTaskP(RunnableQueueP runnableQueueP) {
		this.runnableQueueP = runnableQueueP;
	}
	
	@Override
	public void run() {
		//线程没有中断，则不断从队列中取出Runnable,执行run方法
		while(running && !Thread.currentThread().isInterrupted() ) {
			try {
				Runnable task = runnableQueueP.task();
				task.run();
			} catch (InterruptedException e) {
				running =false;
				break;
			}
		}
	}
	
	//停止当前任务
	public void stop() {
		this.running = false;
	}

}
