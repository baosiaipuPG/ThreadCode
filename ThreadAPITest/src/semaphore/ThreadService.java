package semaphore;

import java.util.concurrent.Semaphore;

public class ThreadService {
	private Semaphore se = new Semaphore(1);
	public void testMethod() {
		try {
			se.acquire();
			System.out.println(Thread.currentThread().getName()
					+"  begin time "+System.currentTimeMillis());
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName()
					+"  end time "+System.currentTimeMillis());
			se.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
