package executorService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AnyTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(new MycallableA());
		list.add(new MycallableB());
		ExecutorService ex = Executors.newCachedThreadPool();
		try {
			List<Future<String>> str =   ex.invokeAll(list,1,TimeUnit.SECONDS);
			for(int i=0;i<str.size();i++) {
				System.out.println("第"+ (i+1) + " 次循环");
				System.out.println("取得返回值  "+str.get(i).get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
