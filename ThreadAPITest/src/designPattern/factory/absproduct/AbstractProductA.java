package designPattern.factory.absproduct;

public class AbstractProductA {
	private String name;
	private String type;
	private int amount;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "AbstractProductA [name=" + name + ", type=" + type + ", amount=" + amount + "]";
	}
	public AbstractProductA(String name, String type, int amount) {
		super();
		this.name = name;
		this.type = type;
		this.amount = amount;
	}
	
}
