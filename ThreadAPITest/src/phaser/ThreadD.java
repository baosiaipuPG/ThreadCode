package phaser;

import java.util.concurrent.Phaser;

import sun.net.www.content.text.plain;

public class ThreadD extends Thread {

	private Phaser phaser;

	public ThreadD(Phaser phaser) {
		super();
		this.phaser = phaser;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " ��ʼ  " + System.currentTimeMillis());
		try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + " phaser " + phaser.getPhase() + "  "
					+ System.currentTimeMillis());
			phaser.arriveAndAwaitAdvance();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ����  " + System.currentTimeMillis());
	}
}
