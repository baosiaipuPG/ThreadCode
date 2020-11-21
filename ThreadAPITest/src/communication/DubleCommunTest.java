package communication;

import java.util.concurrent.TimeUnit;

public class DubleCommunTest {

	public static void main(String[] args) {
		final DubleCommun eventQueue = new DubleCommun();
		for(int i = 1;i<5;i++) {
			new Thread(()->{
				for(;;) {
					eventQueue.off(new DubleCommun.Event());
				}
				},"�������߳�"+i).start() ;
		}
		 
		for(int i = 1;i<5;i++) {
			new Thread(()->{
				for(;;) {
					eventQueue.task();
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				},"�������߳�"+i).start() ;
		}
		
	}

}
