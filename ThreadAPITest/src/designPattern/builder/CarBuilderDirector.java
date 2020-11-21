package designPattern.builder;

public class CarBuilderDirector {
	
	public Car buildEctricCar(CarBuilder builder) {
		builder.buildCar();
		builder.addEngine("�߼��綯��");
		builder.addColor("blue");
		builder.addBatteries(250);
		return builder.getCar();
	};
	
	public Car buildGasolineCar(CarBuilder builder) {
		builder.buildCar();
		builder.addEngine("�߼�ȼ�ͻ�");
		builder.addColor("red");
		builder.addBatteries(550);
		builder.addGasTank(160);
		return builder.getCar();
	};
}
