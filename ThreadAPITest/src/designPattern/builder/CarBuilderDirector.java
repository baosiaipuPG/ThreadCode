package designPattern.builder;

public class CarBuilderDirector {
	
	public Car buildEctricCar(CarBuilder builder) {
		builder.buildCar();
		builder.addEngine("高级电动机");
		builder.addColor("blue");
		builder.addBatteries(250);
		return builder.getCar();
	};
	
	public Car buildGasolineCar(CarBuilder builder) {
		builder.buildCar();
		builder.addEngine("高级燃油机");
		builder.addColor("red");
		builder.addBatteries(550);
		builder.addGasTank(160);
		return builder.getCar();
	};
}
