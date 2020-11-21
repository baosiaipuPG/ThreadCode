package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserTest {

	public static void main(String[] args) {
		UserInfo userInfo = new UserInfo();
		MyRunnableUser myRunnableUser = new MyRunnableUser(userInfo);
		ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
		Future<UserInfo> future = pool.submit(myRunnableUser,userInfo);
		 System.out.println("start  "+System.currentTimeMillis());
		 try {
			userInfo=future.get();
			System.out.println("value "+userInfo.getUserName()+"  "+userInfo.getPassword());
			 System.out.println("end  "+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
