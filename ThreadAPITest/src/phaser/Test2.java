package phaser;

import java.util.concurrent.Phaser;

public class Test2 {
public static void main(String[] args) {
	Phaser phaser = new Phaser(2);
	phaser.register();
	ThreadA a = new ThreadA(phaser);
	a.setName("线程A");
	a.start();
	ThreadA b = new ThreadA(phaser);
	b.setName("线程B");
	b.start();
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	phaser.arriveAndDeregister();
}
}
