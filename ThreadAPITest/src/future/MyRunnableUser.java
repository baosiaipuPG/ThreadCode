package future;

public class MyRunnableUser implements Runnable {
	private UserInfo userInfo;
	
	 
	public MyRunnableUser(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}


	@Override
	public void run() {
		 userInfo.setPassword("123");
		 userInfo.setUserName("pys");

	}

}
