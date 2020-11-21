package scheduledExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedRateTest {

	public static void main(String[] args) {
		ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
		System.out.println("main x start "+System.currentTimeMillis());
		//ex.scheduleAtFixedRate(new MyRunnableA(), 5, 5, TimeUnit.SECONDS);
		ex.scheduleWithFixedDelay(new MyRunnableA(), 2, 3, TimeUnit.SECONDS);
		System.out.println("main x END "+System.currentTimeMillis());

	}

}
