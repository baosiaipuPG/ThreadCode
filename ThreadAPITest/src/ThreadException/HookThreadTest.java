package ThreadException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HookThreadTest {

	public static void main(String[] args) {
		Runtime.getRuntime()
				.addShutdownHook(new Thread(()->{
					System.out.println("hook test 1 running");
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("hook test 1 exit");
				},"HOOK线程1"));
		
		Runtime.getRuntime()
		.addShutdownHook(new Thread(()->{
			System.out.println("hook test 2 running");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hook test 2 exit");
		},"HOOK线程2"));
		
		Runtime.getRuntime()
		.addShutdownHook(new Thread(()->{
			System.out.println("hook test 3 running");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hook test 3 exit");
		},"HOOK线程3"));
		System.out.println("main thread  exit");
		
	}

}
