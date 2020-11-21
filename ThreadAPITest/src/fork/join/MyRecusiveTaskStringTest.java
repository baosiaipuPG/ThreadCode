package fork.join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class MyRecusiveTaskStringTest {

	public static void main(String[] args) {
		MyRecusiveTaskString task = new MyRecusiveTaskString(1,10);
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> task1 = pool.submit(task);
		try {
			System.out.println("result  "+task.get());
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("InterruptedException 子线程异常处理");
		} catch (ExecutionException e) {
			e.printStackTrace();
			System.out.println("ExecutionException  子线程异常处理");
		}
		System.out.println("main end");
		

	}

}
