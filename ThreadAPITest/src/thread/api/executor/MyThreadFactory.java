package thread.api.executor;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("�����̳߳ش�С���Զ����̹߳��� ");
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("�Զ����̴߳����쳣��ʼ "+ thread.getName());
				e.printStackTrace();
			}
		});
		return thread;
	}

}
