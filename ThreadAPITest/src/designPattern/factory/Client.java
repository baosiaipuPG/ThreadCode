package designPattern.factory;

import designPattern.factory.concrete.ConcreteFactory1;
import designPattern.factory.concrete.ConcreteFactory2;

public class Client {

	public static void main(String[] args) {
		ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
		System.out.println(concreteFactory1.createProductA());
		System.out.println(concreteFactory1.createProductB());
		System.out.println("¹¤³§2----------");
		ConcreteFactory2 concreteFactory2 = new ConcreteFactory2();
		System.out.println(concreteFactory2.createProductA());
		System.out.println(concreteFactory2.createProductB());
	}

}
