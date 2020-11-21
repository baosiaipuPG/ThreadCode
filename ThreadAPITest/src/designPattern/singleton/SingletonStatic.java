package designPattern.singleton;

public class SingletonStatic {
	
	private static   SingletonStatic instance;
	static {
		instance = new SingletonStatic();
	}
	private SingletonStatic() {};
	public static SingletonStatic getInstance() {
		return instance;
	}
}
