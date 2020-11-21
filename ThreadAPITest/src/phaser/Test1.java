package phaser;

import java.util.concurrent.Phaser;

public class Test1 {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(2);
		ThreadA a = new ThreadA(phaser);
		a.setName("线程A");
		a.start();
		ThreadC c = new ThreadC(phaser);
		c.setName("线程C");
		c.start();
		ThreadD d = new ThreadD(phaser);
		d.setName("线程D");
		d.start();
	}
}
