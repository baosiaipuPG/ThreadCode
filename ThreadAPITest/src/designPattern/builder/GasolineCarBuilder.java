package designPattern.builder;

public class GasolineCarBuilder  extends CarBuilder{

	private Car car;
	
	@Override
	public void buildCar() {
		car = new Car(); 
	}

	@Override
	public void addEngine(String engine) {
		car.setEngine(engine);
	}

	@Override
	public void addColor(String color) {
		car.setColor(color);
	}

	@Override
	public void addBatteries(int batteries) {
		car.setBatteries(batteries);
		
	}

	@Override
	public void addGasTank(int gasTank) {
		car.setGasTank(gasTank);
	}

	@Override
	public Car getCar() {
		return car;
	}

}
