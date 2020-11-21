package designPattern.factory;

import designPattern.factory.absproduct.AbstractProductA;
import designPattern.factory.absproduct.AbstractProductB;

public abstract class AbstractFactory {
	public abstract AbstractProductA createProductA();
	
	public abstract AbstractProductB createProductB();
}
