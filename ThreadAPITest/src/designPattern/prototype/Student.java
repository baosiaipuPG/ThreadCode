package designPattern.prototype;

public class Student implements Cloneable{
	private String name;
	private int age;
	private Subject subject;
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
		return "Student [name=" + name + ", age=" + age + ", subject=" + subject + "]";
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	@Override
	public Object clone()  {
		try {
			Student student =null;
			student = (Student) super.clone();
			//深拷贝 应用类型单独调用Clone方法    subject implements Cloneable 重写clone返现
			student.subject = (Subject) subject.clone();
			return student;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
}
