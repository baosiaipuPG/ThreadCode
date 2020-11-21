package semaphore;

public class ThreadVolatileTest extends Thread {
	private volatile boolean flag =false;
	@Override
	public void run() {
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("start work");
				while(!flag && !isInterrupted()) {
					System.out.println("线程正在运行");
				}

			}
		};
	}
}
