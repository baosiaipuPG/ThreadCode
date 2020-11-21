package communication;

import java.util.concurrent.TimeUnit;

public class SingleCommunTest {

	public static void main(String[] args) {
		final SingleCommun eventQueue = new SingleCommun();
		for(int i = 1;i<5;i++) {
			new Thread(()->{
				for(;;) {
					eventQueue.off(new SingleCommun.Event());
				}
				},"生产者线程"+i).start() ;
		}
		
//		new Thread(()->{
//			for(;;) {
//				eventQueue.off(new SingleCommun.Event());
//			}
//			},"生产者线程").start() ;
		
		try {
			TimeUnit.MILLISECONDS.sleep(150);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		new Thread(()->{
//			for(;;) {
				eventQueue.task();
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			}
			},"消费者线程").start() ;
	}

}
