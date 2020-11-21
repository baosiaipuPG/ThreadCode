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
			System.out.println(threadName+" 开始跑第一阶段");
			cyc.await();
			System.out.println(threadName+" 跑完第一阶段");
			
			
			Thread.sleep((int) Math.random()*1000);
			System.out.println(threadName+" 开始跑第二阶段");
			cyc.await();
			System.out.println(threadName+" 跑完第二阶段");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
