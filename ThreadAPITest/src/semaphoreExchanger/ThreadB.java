package semaphoreExchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ThreadB  extends Thread{
		private  Exchanger<String> exchanger;
		private static final ThreadLocal<List<AA>> threadLocal2 = new ThreadLocal<List<AA>>() ;
		private static List<AA> list;
		
//		private static ThreadLocal<List<AA>> threadLocal2 = new ThreadLocal<>();
		  
		public static List<AA> getList() {
			return list;
		}
		public static void setList(List<AA> list) {
			ThreadB.list = list;
		}
		public ThreadB(Exchanger<String> exchanger) {
			super();
			this.exchanger = exchanger;
		}
		 @Override
		  public void run() {
				try{
					threadLocal2.set(list);
					String data1 = Thread.currentThread().getName();
					List<AA> cc = threadLocal2.get();
					cc.forEach(h->{
						 System.out.println("---"+h.toString());
					 });
				}catch(Exception e){
					e.printStackTrace();
				}
		  }
		public ThreadB() {
			super();
		}
		 
}
