package designPattern.prototype;

public class Client {

	public static void main(String[] args) {
		Subject subject = new Subject("数学",88);
		Student student = new Student("战三",25);
		student.setSubject(subject);
		Student student1 = (Student) student.clone();
		Student student2 = (Student) student.clone();
		System.out.println("student "+ student );
		System.out.println("student1 "+ student1);
		System.out.println("student2 "+ student2);
		System.out.println("equalsstudent "+ student2.equals(student1));
		System.out.println("equalssubject "+ student2.getSubject().equals(student1.getSubject()));
		
		System.out.println("序列化方式深拷贝 ------------" );
		Subject2Serializable subject22 = new Subject2Serializable("数学2",828);
		Student2Serializable student22 = new Student2Serializable("战三2",225);
		student22.setSubject(subject22);
		Student2Serializable student221 = (Student2Serializable) student22.studentSerClone();
		Student2Serializable student222 = (Student2Serializable) student22.studentSerClone();
		System.out.println("student22 "+ student22 );
		System.out.println("student221 "+ student221);
		System.out.println("student222 "+ student222);
		System.out.println("equalsstudent22 "+ student221.equals(student222));
		System.out.println("equalssubject222 "+ student222.getSubject().equals(student221.getSubject()));
		 
	}

}
