package designPattern.factory.absproduct;

public class AbstractProductB {
	private String name;
	private String type;
	private int nominal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNominal() {
		return nominal;
	}
	public void setNominal(int nominal) {
		this.nominal = nominal;
	}
	@Override
	public String toString() {
		return "AbstractProductB [name=" + name + ", type=" + type + ", nominal=" + nominal + "]";
	}
	public AbstractProductB(String name, String type, int nominal) {
		super();
		this.name = name;
		this.type = type;
		this.nominal = nominal;
	}
	
}
