package CountDownLatchCycliBarrier;

import java.util.concurrent.CyclicBarrier;

public class CycTest2 {

	public static void main(String[] args) {
		CyclicBarrier cyc = new CyclicBarrier(2);
		for (int i = 0; i < 4; i++) {
			Thread a = new MyThreadCyc2(cyc);
			a.setName("Ïß³Ì"+i);
			a.start();
		}

	}

}
