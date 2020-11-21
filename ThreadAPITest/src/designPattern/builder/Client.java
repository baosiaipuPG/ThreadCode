package designPattern.builder;

public class Client {

	public static void main(String[] args) {
		CarBuilderDirector carBuilderDirector = new CarBuilderDirector();
		ElectricCarBuilder electricCarBuilder = new ElectricCarBuilder();
		GasolineCarBuilder gasolineCarBuilder = new GasolineCarBuilder();
		System.out.println(carBuilderDirector.buildEctricCar(electricCarBuilder));
		System.out.println(carBuilderDirector.buildGasolineCar(gasolineCarBuilder));

	}

}
