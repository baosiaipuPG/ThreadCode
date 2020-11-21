package executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterruptTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new MycallableInterruptA());
		list.add(new MycallableInterruptB2());
		ExecutorService ex = Executors.newCachedThreadPool();
		try {
			String str =  (String) ex.invokeAny(list);
			System.out.println("取得返回值  "+str);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
