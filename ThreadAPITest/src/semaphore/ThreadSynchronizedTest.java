package semaphore;

import java.util.concurrent.TimeUnit;

public class ThreadSynchronizedTest {

	public static void main(String[] args) {
		new Thread(ThreadSynchronizedTest::method1,"线程1").start();
		new Thread(ThreadSynchronizedTest::method2,"线程2").start();

	}
	public static synchronized void method1() {
		System.out.println(Thread.currentThread().getName()+"执行1");
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized  void method2() {
		System.out.println(Thread.currentThread().getName()+"执行2");
		try {
			TimeUnit.MINUTES.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public  void method2() {
//		synchronized (this) {
//			System.out.println(Thread.currentThread().getName()+"执行2");
//			try {
//				TimeUnit.MINUTES.sleep(2);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}

}
