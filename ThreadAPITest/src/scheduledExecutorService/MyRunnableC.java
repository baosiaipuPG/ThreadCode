package scheduledExecutorService;

import java.util.concurrent.TimeUnit;

public class MyRunnableC implements Runnable {

	private String name;
	
	public MyRunnableC(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run()  {
		try {
			while(true) {
				if(Thread.currentThread().isInterrupted()==true) {
					throw new InterruptedException();
				}
				System.out.println(name+"  run start "+ System.currentTimeMillis());
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("线程中断了");
		}
		 
		 
		 
	}

}
