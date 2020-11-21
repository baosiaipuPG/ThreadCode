package scheduledExecutorService;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CancelTest {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
		Runnable a = new MyRunnableC("A");
		ScheduledFuture fua = pool.schedule(a, 1, TimeUnit.SECONDS);
		pool.setRemoveOnCancelPolicy(true);
		System.out.println(fua.cancel(true));
		BlockingQueue<Runnable> queue = pool.getQueue();
		Iterator<Runnable> it = queue.iterator();
		while (it.hasNext()) {
			Runnable h = it.next();
			System.out.println("队列中的 " + h);
		}
		System.out.println("main end");
	}

//	public static void main(String[] args) {
//		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
//		Runnable a = new MyRunnableC("A");
//		ScheduledFuture fua = pool.schedule(a, 0, TimeUnit.SECONDS);
//		BlockingQueue<Runnable> queue = pool.getQueue();
//		System.out.println("queue size "+queue.size());
//		try {
//			TimeUnit.SECONDS.sleep(2);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(fua.cancel(true));
//		queue = pool.getQueue();
//		System.out.println("queue size "+queue.size());
//		System.out.println("main end");
//	}
}
