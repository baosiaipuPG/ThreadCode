package ThreadPool;

public class InternalTaskP implements Runnable{
	private final RunnableQueueP runnableQueueP;
	private volatile boolean running =true;
	
	public InternalTaskP(RunnableQueueP runnableQueueP) {
		this.runnableQueueP = runnableQueueP;
	}
	
	@Override
	public void run() {
		//�߳�û���жϣ��򲻶ϴӶ�����ȡ��Runnable,ִ��run����
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
	
	//ֹͣ��ǰ����
	public void stop() {
		this.running = false;
	}

}
