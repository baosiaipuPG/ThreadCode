package phaser;

import java.util.concurrent.Phaser;

public class Test1 {
	public static void main(String[] args) {
		Phaser phaser = new Phaser(2);
		ThreadA a = new ThreadA(phaser);
		a.setName("�߳�A");
		a.start();
		ThreadC c = new ThreadC(phaser);
		c.setName("�߳�C");
		c.start();
		ThreadD d = new ThreadD(phaser);
		d.setName("�߳�D");
		d.start();
	}
}
