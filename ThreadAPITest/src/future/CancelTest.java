package future;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CancelTest {

	public static void main(String[] args) {
		MyCallableCancel myCallableCancel = new MyCallableCancel();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS, new LinkedBlockingDeque());
		Future<String> future = pool.submit(myCallableCancel);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("cancel "+future.cancel(false)+"  isCancel  "+future.isCancelled());
	}

}
