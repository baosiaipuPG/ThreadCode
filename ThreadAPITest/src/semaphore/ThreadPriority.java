package semaphore;

public class ThreadPriority {

	public static void main(String[] args) {
			Thread t1 = new Thread(()->{
				System.out.print("t1  ");
			}) ;
			t1.setPriority(3);
			
			Thread t2 = new Thread(()->{
				System.out.print("t2  ");
			}) ;
			t2.setPriority(8);
			t1.start();
			t2.start();
	}
}
