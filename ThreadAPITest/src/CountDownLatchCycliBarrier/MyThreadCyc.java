package CountDownLatchCycliBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThreadCyc extends Thread{

	private CyclicBarrier cyc;
	
	public MyThreadCyc(CyclicBarrier cyc) {
		this.cyc = cyc;
	}

	@Override
	public void run() {
	 
		try {
			System.out.println(Thread.currentThread().getName()+" 等待筹齐2个线程再继续运行");
			cyc.await();
			System.out.println(Thread.currentThread().getName()+" 已经筹齐2个线程开始继续运行");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
