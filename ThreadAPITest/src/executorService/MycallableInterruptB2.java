package executorService;

import java.util.concurrent.Callable;

public class MycallableInterruptB2 implements Callable<String> {

	@Override
	public String call() throws Exception {
			System.out.println("B2 start "+System.currentTimeMillis());
			for(int i=0;i<200;i++) {
				if(Thread.currentThread().isInterrupted()==false) {
					Math.random();
					System.out.println("B2 中 "+(i+1)+"  在运行");
				}else {
					System.out.println("B2 线程中断");
					throw new InterruptedException();
				}
			}
			System.out.println("B2 end "+System.currentTimeMillis());
		return "call result B2";
	}

}
