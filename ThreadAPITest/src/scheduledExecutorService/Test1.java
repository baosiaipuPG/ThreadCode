package scheduledExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		List<Callable> list = new ArrayList<Callable>();
		list.add(new MyCallableA());
		list.add(new MyCallableB());
		// ������һ����ִ�мƻ�
//		ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
		// ����������ִ�мƻ�
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(2);
		ScheduledFuture<String> fua = ex.schedule(list.get(0), 4, TimeUnit.SECONDS);
		ScheduledFuture<String> fub = ex.schedule(list.get(1), 4, TimeUnit.SECONDS);
		System.out.println("main x start "+System.currentTimeMillis());
		try {
			System.out.println("����ֵA "+fua.get());
			System.out.println("����ֵB "+fub.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main x end "+System.currentTimeMillis());

	}

}
