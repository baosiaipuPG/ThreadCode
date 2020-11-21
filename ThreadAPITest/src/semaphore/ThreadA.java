package semaphore;

public class ThreadA implements  Runnable{
	private ThreadService service;

	public ThreadA(ThreadService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		service.testMethod();
	}
}
