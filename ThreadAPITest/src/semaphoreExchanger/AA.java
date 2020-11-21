package semaphoreExchanger;

public class AA {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "AA [name=" + name + ", age=" + age + "]";
	}
	public AA(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
