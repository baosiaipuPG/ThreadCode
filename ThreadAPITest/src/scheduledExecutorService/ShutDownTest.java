package scheduledExecutorService;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ShutDownTest {

	public static void main(String[] args) {
		ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
		Runnable a = new MyRunnableB("A");
//		pool.schedule(a, 3, TimeUnit.SECONDS);
//		pool.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
		pool.scheduleAtFixedRate(a, 5, 5, TimeUnit.SECONDS);
		//继续执行
//		pool.setContinueExistingPeriodicTasksAfterShutdownPolicy(true);
		pool.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
		pool.shutdown();
		System.out.println("任务已经停掉");

	}

}
