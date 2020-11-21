package CountDownLatchCycliBarrier;

import java.util.concurrent.CountDownLatch;

public class MyThread1 extends Thread {
	private CountDownLatch comintTag;
	private CountDownLatch waitTag;
	private CountDownLatch endTag;

	public MyThread1(CountDownLatch comintTag, CountDownLatch waitTag, CountDownLatch endTag) {
		super();
		this.comintTag = comintTag;
		this.waitTag = waitTag;
		this.endTag = endTag;
	}

	@Override
	public void run() {
		try {
			String threadName = Thread.currentThread().getName() + "--";
			System.out.println(threadName + "运动员正赶往起跑点");
			Thread.sleep((int) Math.random() * 1000);
			System.out.println(threadName + "跑到起点");
			comintTag.countDown();
			System.out.println(threadName + "等待起跑指令");
			waitTag.await();
			System.out.println(threadName + "跑出起点");
			Thread.sleep((int) Math.random() * 1000);
			System.out.println(threadName + "跑到终点");
			endTag.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
