package CompletionService;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("B start " + System.currentTimeMillis());
		Thread.sleep(5000);
		int i = 1/0;
		System.out.println("B end " + System.currentTimeMillis());
		return "result call B";
	}

}
