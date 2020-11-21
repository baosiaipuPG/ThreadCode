package designPattern.singleton;

public class SingletonSyn {
	
	private static volatile SingletonSyn instance;
	private SingletonSyn() {};
	public static SingletonSyn getInstance() {
		if(instance == null) {
			synchronized (SingletonSyn.class) {
				if(instance == null) {
					instance = new SingletonSyn();
				}
			}
		}
		return instance;
	}
}
