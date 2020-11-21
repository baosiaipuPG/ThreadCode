package CompletionService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class PollTest {

	public static void main(String[] args) {
		ExecutorService exce = Executors.newCachedThreadPool();
		ExecutorCompletionService cs =new ExecutorCompletionService(exce);
		cs.submit(new Callable(){
			
			public String call() throws Exception{
				Thread.sleep(3000);
				System.out.println("开始执行任务"+"  "+System.currentTimeMillis());
				return "call ruselt 100";
			}
		});
		System.out.println(cs.poll()+"  "+System.currentTimeMillis());

	}

}
