package scheduledExecutorService;

import java.util.concurrent.TimeUnit;

public class MyRunnableA implements Runnable {

	@Override
	public void run()  {
		String name = Thread.currentThread().getName();
		System.out.println(name+"  callA start "+ System.currentTimeMillis());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+"  callA end "+ System.currentTimeMillis());
	}

}
