package CountDownLatchCycliBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThreadCyc2 extends Thread{

	private CyclicBarrier cyc;
	
	public MyThreadCyc2(CyclicBarrier cyc) {
		this.cyc = cyc;
	}

	@Override
	public void run() {
	 
		try {
			Thread.sleep((int) Math.random()*1000);
			String threadName = Thread.currentThread().getName()+"--";
			System.out.println(threadName+" ��ʼ�ܵ�һ�׶�");
			cyc.await();
			System.out.println(threadName+" �����һ�׶�");
			
			
			Thread.sleep((int) Math.random()*1000);
			System.out.println(threadName+" ��ʼ�ܵڶ��׶�");
			cyc.await();
			System.out.println(threadName+" ����ڶ��׶�");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
