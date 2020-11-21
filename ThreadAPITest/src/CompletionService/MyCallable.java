package CompletionService;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private String name;
	private long sleepValue;
	
	public MyCallable(String name, long sleepValue) {
		super();
		this.name = name;
		this.sleepValue = sleepValue;
	}

	@Override
	public String call() throws Exception {
	System.out.println(name);
	Thread.sleep(sleepValue);
		return "result call "+name;
	}

}
