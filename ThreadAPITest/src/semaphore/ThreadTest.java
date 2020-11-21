package semaphore;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		ReentrantLock  lock = new ReentrantLock ();
		lock.lock();
//		Thread t = new Thread(()->{
//			try {
//				TimeUnit.MINUTES.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println("I am  Interrupted  "+Thread.);
//			}
//		});
//		Thread t = new  Thread() {
//			@Override
//			public void run() {
//				try {
//					TimeUnit.MINUTES.sleep(1);
//				} catch (InterruptedException e) {
//					System.out.println("I am  Interrupted  "+isInterrupted());
//				}	
//			}
//		};
//		//�������ػ��߳�  ��Ȼ�̲߳�����ֹ
//		t.setDaemon(true);
//		t.start();
//		TimeUnit.MILLISECONDS.sleep(2);
//		System.out.println("Thread is Interrupted  "+t.isInterrupted());
//		t.interrupt();
//		TimeUnit.MILLISECONDS.sleep(2);
//		System.out.println("Thread is Interrupted  "+t.isInterrupted());

		System.out.println("main Thread is Interrupted  "+Thread.interrupted());
		Thread.currentThread().interrupt();
		System.out.println("main Thread is Interrupted  "+Thread.currentThread().isInterrupted());
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("�����ж��ź�");
		}	
		 
	}
	

}
