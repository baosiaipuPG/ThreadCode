package scheduledExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallableB implements Callable<String> {

	@Override
	public String call() throws Exception {
		String name = Thread.currentThread().getName();
		System.out.println(name+"  callB start "+ System.currentTimeMillis());
		System.out.println(name+"  callB end "+ System.currentTimeMillis());
		return "result callB";
	}

}
