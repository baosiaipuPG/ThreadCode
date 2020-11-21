package ThreadPool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadPoolPTest {
	
	
	public static void main(String[] args) {
		//��ʼ���߳���2������ 4�����6�������������100�� Ĭ�Ϸ����������
		final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100);
		
		//��ʼ���߳���2������ 4�����6�������������100,�׳��쳣
		//final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100,new DenyPolicyP.AbortDenyPolicyP());
		//��ʼ���߳���2������ 4�����6�������������100,���ύ�ߵ��߳���ִ��
		//final ThreadPoolP threadPoolP = new BasicThreadPoolP(2,6,4,100,new DenyPolicyP.RunnerDenyPolicyP());
		for(int i=0;i<110;i++) {
			threadPoolP.execute(()->{
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println(Thread.currentThread().getName()+"��������");
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
