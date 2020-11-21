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
			System.out.println(threadName + "�˶�Ա���������ܵ�");
			Thread.sleep((int) Math.random() * 1000);
			System.out.println(threadName + "�ܵ����");
			comintTag.countDown();
			System.out.println(threadName + "�ȴ�����ָ��");
			waitTag.await();
			System.out.println(threadName + "�ܳ����");
			Thread.sleep((int) Math.random() * 1000);
			System.out.println(threadName + "�ܵ��յ�");
			endTag.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
