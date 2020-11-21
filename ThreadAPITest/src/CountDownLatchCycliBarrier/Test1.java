package CountDownLatchCycliBarrier;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Test1 {

	public static void main(String[] args) {
		  CountDownLatch comintTag = new CountDownLatch(4);
		  CountDownLatch waitTag = new CountDownLatch(1);
		  CountDownLatch endTag = new CountDownLatch(4);
		  MyThread1[] thread1s = new MyThread1[4];
		  Arrays.stream(thread1s).forEach(m->{
			  m=new MyThread1(comintTag, waitTag, endTag);
			  m.start();
		  });
		  System.out.println("���еȴ��˶�Ա����");
		  try {
			comintTag.await();
			System.out.println("�˶�Ա������ϣ�������������");
			waitTag.countDown();
			System.out.println("�ȴ�����ͳ������");
			endTag.await();
			System.out.println("����ͳ������");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  

	}

}
