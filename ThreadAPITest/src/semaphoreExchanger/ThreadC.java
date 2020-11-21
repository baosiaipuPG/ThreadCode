package semaphoreExchanger;

import java.util.concurrent.Exchanger;

public class ThreadC  extends Thread{
		private  Exchanger<String> exchanger;

		public ThreadC(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}
		 @Override
		  public void run() {
			  try {
				System.out.println(Thread.currentThread().getName() +"中获取线程 "+exchanger.exchange("线程值33"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
}
