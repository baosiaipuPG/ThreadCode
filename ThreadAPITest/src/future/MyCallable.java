package future;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		 Thread.sleep(1000);
		return "callable call result 100";
	}

}
