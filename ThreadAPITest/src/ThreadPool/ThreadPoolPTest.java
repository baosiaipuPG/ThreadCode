package ThreadPool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadPoolPTest {
	
	
	public static void main(String[] args) {
		//初始化线程数2，核心 4，最大6，队列最大任务100， 默认放弃任务策略
		final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100);
		
		//初始化线程数2，核心 4，最大6，队列最大任务100,抛出异常
		//final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100,new DenyPolicyP.AbortDenyPolicyP());
		//初始化线程数2，核心 4，最大6，队列最大任务100,在提交者的线程中执行
		//final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100,new DenyPolicyP.RunnerDenyPolicyP());
		for(int i=0;i<110;i++) {
			threadPoolP.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName()+"在运行中");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		while(!threadPoolP.isShutdown()) {
			System.out.println("getActiveCount :"+threadPoolP.getActiveCount());
			System.out.println("getQueueSize :"+threadPoolP.getQueueSize());
			System.out.println("getCoreSize :"+threadPoolP.getCoreSize());
			System.out.println("getMaxSize :"+threadPoolP.getMaxSize());
			try {
				TimeUnit.SECONDS.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		try {
//			TimeUnit.SECONDS.sleep(50);
//			threadPoolP.shutdown();
//			Thread.currentThread().join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
