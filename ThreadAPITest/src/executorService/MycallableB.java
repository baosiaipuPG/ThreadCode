package executorService;

import java.util.concurrent.Callable;

public class MycallableB implements Callable<String> {

	@Override
	public String call() throws Exception {
//		try {
		System.out.println("B start "+System.currentTimeMillis());
		for(int i=0;i<20;i++) {
			Thread.sleep(100);
			System.out.println("B �� "+(i+1)+"  ������");
		}
//		 int i =1/0;
		System.out.println("B end "+System.currentTimeMillis());
//		}catch (Exception e) {
//		System.out.println("A  ��ʾ�����쳣 ");
//		e.printStackTrace();
//		throw e;
//	}
		return "call result B";
	}

}
