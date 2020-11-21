package CompletionService;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class ExceptionTest {

	public static void main(String[] args) {
		MyCallableA a = new MyCallableA();
		MyCallableB b = new MyCallableB();
		Executor ex = Executors.newCachedThreadPool();
		CompletionService com = new ExecutorCompletionService(ex);
		com.submit(b);
		com.submit(a);
		 
		try {
			System.out.println("task 1 " + com.take().get());
			System.out.println("task 2 " + com.take().get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("main end");

	}

}
