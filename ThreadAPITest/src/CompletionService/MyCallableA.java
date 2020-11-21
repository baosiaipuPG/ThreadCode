package CompletionService;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("A start " + System.currentTimeMillis());
		Thread.sleep(1000);
		System.out.println("A end " + System.currentTimeMillis());
		return "result call A";
	}

}
