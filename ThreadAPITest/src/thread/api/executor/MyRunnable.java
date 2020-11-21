package thread.api.executor;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MyRunnable implements Runnable{
	
	private String uaseName;
	private Set<String> uuid ;
	public MyRunnable(String uaseName,Set<String> uuid ) {
		super();
		this.uaseName = uaseName;
		this.uuid=uuid;
	}

	public String getUaseName() {
		return uaseName;
	}

	public void setUaseName(String uaseName) {
		this.uaseName = uaseName;
	}

	@Override
	public void run() {
		 System.out.println("线程 "+uaseName+" 开始执行");
			for(int i=0;i<10;i++) {
				String uu = UUID.randomUUID().toString();
				System.out.println(uu); 
				uuid.add(uu);
			}
			 
		System.out.println("线程 "+uaseName+" 执行完成 "+uuid.size());
	}

}
