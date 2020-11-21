package semaphore;

public class ThreadB extends Thread {
	private ThreadService service;

	public ThreadB(ThreadService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
}
