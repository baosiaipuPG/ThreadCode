package phaser;

import java.util.concurrent.Phaser;

import sun.net.www.content.text.plain;

public class ThreadA extends Thread{

	private Phaser phaser;
	
	public ThreadA(Phaser phaser) {
		super();
		this.phaser = phaser;
	}

	@Override
	public void run() {
		 System.out.println(Thread.currentThread().getName()+" ��ʼ "+System.currentTimeMillis());
		 phaser.arriveAndAwaitAdvance();
		 System.out.println(Thread.currentThread().getName()+" ���� "+System.currentTimeMillis());
	}
}
