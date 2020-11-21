package semaphoreExchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
	public static void main(String[] args) {
		ExecutorService service =Executors.newFixedThreadPool(2);
		List<AA> list = new ArrayList<AA>();
		for(int i=1;i<100;i++) {
			list.add(new AA("111asd"+i,i));
		}
		ThreadA a = new ThreadA();
		a.setList(new ArrayList<AA>(list));
		ThreadB b = new ThreadB();
		b.setList(new ArrayList<AA>(list));
		a.start();
		b.start();
		
//		service.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				try{
//					 threadLocal1.set(list);
//					String data1 = Thread.currentThread().getName();
//					List<AA> cc = threadLocal1.get();
//					cc.forEach(h->{
//						 System.out.println("---"+h.toString());
//					 });
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//				
//				
//			}
//		});
//		
//		service.execute(new Runnable() {
//			 
//			@Override
//			public void run() {
//				try{
//					 threadLocal2.set(list);
//					String data =Thread.currentThread().getName();
//					List<AA> aa = threadLocal2.get();
//					aa.forEach(r->{
//						r.setAge(900);
////						System.out.println("****"+r.toString());
//					}); 
//					
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		service.execute(new Runnable() {
//			
//			@Override
//			public void run() {
//				try{
//					String data1 = "钱复合肥";
//					System.out.println("线程"+Thread.currentThread().getName()+
//							"正在把数据 "+data1+" 交换出去");
//					Thread.sleep((long)(Math.random()*10000));
//					String data2 =(String)exchanger.exchange(data1);
//					System.out.println("线程 "+Thread.currentThread().getName()+
//							"交换回来的数据是: "+data2);
//				}catch(Exception e){
//					e.printStackTrace();
//				}
//				
//				
//			}
//		});
	}
 

}
