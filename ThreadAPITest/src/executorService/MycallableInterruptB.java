package executorService;

import java.util.concurrent.Callable;

public class MycallableInterruptB implements Callable<String> {

	@Override
	public String call() throws Exception {
			System.out.println("B start "+System.currentTimeMillis());
			for(int i=0;i<200;i++) {
				Math.random();
				System.out.println("B 中 "+(i+1)+"  在运行");
			}
			System.out.println("B end "+System.currentTimeMillis());
		return "call result B";
	}

}
