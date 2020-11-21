package thread.api.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) { 
		super.afterExecute(r, t);
		System.out.println(((MyRunnable) r).getUaseName() +"执行完毕");
	}
	
	@Override
	protected void beforeExecute(Thread t, Runnable r){ 
		super.beforeExecute(t,r);
		System.out.println(((MyRunnable) r).getUaseName() +"开始执行");
	}	 
}
