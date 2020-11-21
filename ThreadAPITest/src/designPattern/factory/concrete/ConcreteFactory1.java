package designPattern.factory.concrete;

import designPattern.factory.AbstractFactory;
import designPattern.factory.product.ProductA1;
import designPattern.factory.product.ProductB1;

public class ConcreteFactory1 extends AbstractFactory{
	
	@Override
	public  ProductA1 createProductA() {
		return new ProductA1("ProductA1", "ծȯ", 5000);
	};
	@Override
	public  ProductB1 createProductB() {
		return new ProductB1("ProductB1", "�浥", 6000);
	};
}
