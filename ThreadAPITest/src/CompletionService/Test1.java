package CompletionService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) {
		MyCallable call1 = new MyCallable("任务1", 4000);
		MyCallable call2 = new MyCallable("任务2", 3000);
		MyCallable call3 = new MyCallable("任务3", 2000);
		List<Callable> list = new ArrayList<Callable>();
		list.add(call1);
		list.add(call2);
		list.add(call3);
		ThreadPoolExecutor poll = new ThreadPoolExecutor(5, 7, 5, TimeUnit.SECONDS, new LinkedBlockingDeque());
		CompletionService cs = new ExecutorCompletionService(poll);
		list.forEach(m -> {
			cs.submit(m);
		});
		try {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("打印  " + i + "  返回值");
				System.out.println(cs.take().get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
