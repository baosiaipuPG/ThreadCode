package fork.join;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class MyRecursiveTaskTest {

	public static void main(String[] args) {
		MyRecursiveTask task = new MyRecursiveTask();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> task1 = pool.submit(task);
		try {
			System.out.println("result  "+task1.get());
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
