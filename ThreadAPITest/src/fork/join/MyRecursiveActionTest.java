package fork.join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MyRecursiveActionTest {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		pool.submit(new MyRecursiveAction(1,10));
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
