package executorService;

import java.util.concurrent.Callable;

public class MycallableA implements Callable<String> {

	@Override
	public String call() throws Exception {
//		try {
			System.out.println("A start "+System.currentTimeMillis());
			for(int i=0;i<5;i++) {
				Thread.sleep(100);
				System.out.println("A �� "+(i+1)+"  ������");
			}
//			int i = 1/0;
			System.out.println("A end "+System.currentTimeMillis());
//		}catch (Exception e) {
//			System.out.println("A  ��ʾ�����쳣 ");
//			throw e;
//		}
		 
		return "call result A";
	}

}
