package future;

import java.util.concurrent.Callable;

public class MyCallableCancel implements Callable<String> {

	@Override
	public String call() throws Exception {
		 
		 while(1==1) {
			 if(Thread.currentThread().isInterrupted()) {
				 throw new InterruptedException();
			 }
			 System.out.println("�߳�������");
			 Thread.sleep(200);
		 }
	}

}
