package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		 MyCallable myCallable = new MyCallable();
		 ThreadPoolExecutor pool = new ThreadPoolExecutor(2,3,5,TimeUnit.SECONDS,new LinkedBlockingDeque());
		 System.out.println("start  "+System.currentTimeMillis());
		 Future<String> future = pool.submit(myCallable);
		 try {
			System.out.println("get  "+future.get()+" isDone "+future.isDone());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("end  "+System.currentTimeMillis());
		 
	}

}
