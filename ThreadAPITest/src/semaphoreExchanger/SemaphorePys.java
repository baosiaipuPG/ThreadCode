package semaphoreExchanger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphorePys {
	private Semaphore semaphore  = new Semaphore(1);
	public void testMethod() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+" 开始运行");
//					TimeUnit.SECONDS.sleep(5);
					for(int i=0;i<5000;i++) {
						Math.random();
					}
					System.out.println(Thread.currentThread().getName()+" 运行结束");
					semaphore.release();
					semaphore.drainPermits();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
}
