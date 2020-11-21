package future;

public class MyRunnable implements Runnable {
	private String name;
	
	 
	public MyRunnable(String name) {
		super();
		this.name = name;
	}


	@Override
	public void run() {
		 System.out.println(name+" ÔÚÔËÐÐ");

	}

}
