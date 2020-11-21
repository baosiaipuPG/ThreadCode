package scheduledExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallableA implements Callable<String> {

	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		System.out.println(name+"  callA start "+ System.currentTimeMillis());
		TimeUnit.SECONDS.sleep(1);
		System.out.println(name+"  callA end "+ System.currentTimeMillis());
		return "result callA";
	}

}
