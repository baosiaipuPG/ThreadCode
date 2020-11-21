package CountDownLatchCycliBarrier;

import java.util.concurrent.CyclicBarrier;

public class CycTest {

	public static void main(String[] args) {
		CyclicBarrier cyc = new CyclicBarrier(2, new Runnable() {

			@Override
			public void run() {
				System.out.println("∂ºµΩ¡À");

			}
		});
		for (int i = 0; i < 4; i++) {
			Thread a = new MyThreadCyc(cyc);
			a.start();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
