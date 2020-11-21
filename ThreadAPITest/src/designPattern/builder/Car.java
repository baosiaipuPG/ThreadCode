package designPattern.builder;

public class Car {
	private String engine;
	private String color;
	private int batteries;
	private int gasTank;
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getBatteries() {
		return batteries;
	}
	public void setBatteries(int batteries) {
		this.batteries = batteries;
	}
	public int getGasTank() {
		return gasTank;
	}
	public void setGasTank(int gasTank) {
		this.gasTank = gasTank;
	}
	@Override
	public String toString() {
		return "Car [engine=" + engine + ", color=" + color + ", batteries=" + batteries + ", gasTank=" + gasTank + "]";
	}
 
	
}
