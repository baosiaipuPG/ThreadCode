package designPattern.builder;

public abstract class CarBuilder {
	public abstract void buildCar();
	
	public abstract void addEngine(String engine);
	
	public abstract void addColor(String color);
	
	public abstract void addBatteries(int batteries);
	
	public abstract void addGasTank(int gasTank);
	
	public abstract Car getCar();
}
