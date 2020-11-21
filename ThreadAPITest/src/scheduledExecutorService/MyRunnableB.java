package scheduledExecutorService;

import java.util.concurrent.TimeUnit;

public class MyRunnableB implements Runnable {

	private String name;
	
	public MyRunnableB(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run()  {
		System.out.println(name+"  callA start "+ System.currentTimeMillis());
		 
	}

}
