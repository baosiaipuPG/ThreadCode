package semaphoreExchanger;

import java.util.ArrayList;
import java.util.List;

public class ThreadA extends Thread{
	private static final ThreadLocal<List<AA>> threadLocal1 = new ThreadLocal<List<AA>>() ;
	private static List<AA> list;
	
  public static List<AA> getList() {
		return list;
	}
	public static void setList(List<AA> list) {
		ThreadA.list = list;
	}
private SemaphorePys semaphorePys;
//  private static ThreadLocal<List<AA>> threadLocal1 = new ThreadLocal<>();
   
//public static ThreadLocal<List<AA>> getThreadLocal1() {
//	return threadLocal1;
//}
//public static void setThreadLocal1(ThreadLocal<List<AA>> threadLocal1) {
//	ThreadA.threadLocal1 = threadLocal1;
//}
public ThreadA(SemaphorePys semaphorePys) {
	super();
	this.semaphorePys = semaphorePys;
}
  @Override
  public void run() {
	  try{
		  threadLocal1.set(list);
			String data =Thread.currentThread().getName();
			List<AA> aa = threadLocal1.get();
			aa.forEach(r->{
				r.setAge(900);
				System.out.println("***"+r.toString());
			}); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
  }
public ThreadA() {
	super();
}
  
}
