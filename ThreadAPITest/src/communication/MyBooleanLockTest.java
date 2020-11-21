package communication;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyBooleanLockTest {

	private final MyLock mylock = new MyBooleanLock();
	public void syncMethod() {
			try {
				mylock.lock();
				System.out.println(Thread.currentThread().getName()+" "+"获得锁");
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName()+" 线程被中断");
			}finally {
				mylock.unlock();
			}
	}
	public static void main(String[] args) throws InterruptedException    {
		MyBooleanLockTest bl =new MyBooleanLockTest();
		new Thread(bl::syncMethod1,"线程1").start();
		TimeUnit.MILLISECONDS.sleep(2);
		Thread t2 = new Thread(bl::syncMethod1,"线程2");
		t2.start();
		TimeUnit.MILLISECONDS.sleep(10);
	}
	public void syncMethod1() {
		try {
			mylock.lock(1000);
			System.out.println(Thread.currentThread().getName()+" "+"获得锁");
			TimeUnit.SECONDS.sleep(10);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InterruptedException e) {
			
		}finally {
			mylock.unlock();
		}
	}
	
}
