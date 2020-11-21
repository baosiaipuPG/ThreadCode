package designPattern.singleton;

public class Client {

	public static void main(String[] args) {
		 for(int i = 0; i < 5; i++) {
			 Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					 SingletonSyn sy = SingletonSyn.getInstance();
					 System.out.println(sy);
				}
			});
			 t.start();
		 }
		 
		 for(int i = 0; i < 5; i++) {
			 Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					SingletonStatic sy = SingletonStatic.getInstance();
					 System.out.println(sy);
				}
			});
			 t.start();
		 }

	}

}
