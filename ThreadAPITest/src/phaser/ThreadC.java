package phaser;

import java.util.concurrent.Phaser;

import sun.net.www.content.text.plain;

public class ThreadC extends Thread{

	private Phaser phaser;
	
	public ThreadC(Phaser phaser) {
		super();
		this.phaser = phaser;
	}

	@Override
	public void run() {
		 System.out.println(Thread.currentThread().getName()+" ¿ªÊ¼  "+System.currentTimeMillis());
		 try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + " phaser " + phaser.getPhase() + "  "
					+ System.currentTimeMillis());
			phaser.awaitAdvance(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println(Thread.currentThread().getName()+" ½áÊø  "+System.currentTimeMillis());
	}
}
