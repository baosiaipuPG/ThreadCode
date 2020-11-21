package future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		ThreadPoolExecutor pool = (ThreadPoolExecutor) service;
		pool.setRejectedExecutionHandler(new MyReject());
		pool.submit(new MyRunnable("A"));
		pool.submit(new MyRunnable("B"));
		pool.submit(new MyRunnable("C"));
		pool.shutdown();
		pool.submit(new MyRunnable("D"));
	}

}
