package designPattern.factory.concrete;

import designPattern.factory.AbstractFactory;
import designPattern.factory.product.ProductA2;
import designPattern.factory.product.ProductB2;

public class ConcreteFactory2 extends AbstractFactory{
	
	@Override
	public  ProductA2 createProductA() {
		return new ProductA2("ProductA2", "ծȯ2", 5200);
	};
	@Override
	public ProductB2 createProductB() {
		return new ProductB2("ProductB2", "�浥2", 38500);
	};

}
