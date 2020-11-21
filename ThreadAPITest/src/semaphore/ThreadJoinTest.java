package semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ThreadJoinTest {
	public static void main(String[] args) throws InterruptedException {
		Task t = new Task();
		t.start();
		TimeUnit.MILLISECONDS.sleep(1);
		t.close();
		System.out.println("shutdown");
	}
	static class Task  extends Thread  {
		private volatile boolean flag =false;
		@Override
		public void run() {
			System.out.println("start work");
			while(!flag && !isInterrupted()) {
				System.out.println("线程正在运行");
			}
		}
		public void close() {
			this.flag=true;
			this.interrupt();
		}
	}
	
	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
