package scheduledExecutorService;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTest {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(2);
		Runnable a = new MyRunnableB("A");
		Runnable b = new MyRunnableB("B");
		Runnable c = new MyRunnableB("C");
		ScheduledFuture aa= pool.scheduleAtFixedRate(a, 3, 1, TimeUnit.SECONDS);
		ScheduledFuture bb=pool.scheduleAtFixedRate(b, 5, 1, TimeUnit.SECONDS);
		ScheduledFuture cc=pool.scheduleAtFixedRate(c, 10, 1, TimeUnit.SECONDS);
		System.out.println("***");
		try {
			//删除成功
			TimeUnit.SECONDS.sleep(6);
			
			System.out.println("删除任务B " + pool.remove((Runnable)bb));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BlockingQueue<Runnable> queue = pool.getQueue();
		Iterator<Runnable> it = queue.iterator();
		while (it.hasNext()) {
			Runnable h = it.next();
			System.out.println("队列中的 " + h);
		}

	}

}
