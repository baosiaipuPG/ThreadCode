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
			System.out.println(Thread.currentThread().getName()+" �ȴ�����2���߳��ټ�������");
			cyc.await();
			System.out.println(Thread.currentThread().getName()+" �Ѿ�����2���߳̿�ʼ��������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
