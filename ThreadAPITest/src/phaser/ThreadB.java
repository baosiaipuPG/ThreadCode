package phaser;

import java.util.concurrent.Phaser;

import sun.net.www.content.text.plain;

public class ThreadB extends Thread{

	private Phaser phaser;
	
	public ThreadB(Phaser phaser) {
		super();
		this.phaser = phaser;
	}

	@Override
	public void run() {
		 System.out.println(Thread.currentThread().getName()+" ¿ªÊ¼");
		 phaser.arriveAndAwaitAdvance();
		 System.out.println(Thread.currentThread().getName()+" ½áÊø");
	}
}
