package executorService;

import java.util.concurrent.Callable;

public class MycallableInterruptA implements Callable<String> {

	@Override
	public String call() throws Exception {
			System.out.println("A start "+System.currentTimeMillis());
			for(int i=0;i<10;i++) {
				Math.random();
				System.out.println("A 中 "+(i+1)+"  在运行");
			}
			System.out.println("A end "+System.currentTimeMillis());
		return "call result A";
	}

}
