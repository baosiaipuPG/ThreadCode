package thread.api.executor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		MyThreadPoolExecutor myT = new MyThreadPoolExecutor(2,2,5,TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		Set<String> uuid = new HashSet<>();
		MyRunnable my = new MyRunnable("A1",uuid);
		myT.execute(my);
		myT.execute(my);
		myT.execute(my);
		 System.out.println("main size"+uuid.size());
	}

}
