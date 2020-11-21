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
				System.out.println(Thread.currentThread().getName() +"�л�ȡ�߳� "+exchanger.exchange("�߳�ֵ33"));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
}
