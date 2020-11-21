package designPattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student2Serializable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private Subject2Serializable subject;
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
	 
	 
	public Student2Serializable(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student2Serializable() {
		super();
	}
	public Subject2Serializable getSubject() {
		return subject;
	}
	public void setSubject(Subject2Serializable subject) {
		this.subject = subject;
	}
	 
	public Object studentSerClone() {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			//序列化
			 bos = new ByteArrayOutputStream();
			 oos = new ObjectOutputStream(bos);
			 oos.writeObject(this);
			 
			 //反序列化
			 bis = new ByteArrayInputStream(bos.toByteArray());
			 ois = new ObjectInputStream(bis);
			 Student2Serializable serializable = (Student2Serializable) ois.readObject();
			 return serializable;
		} catch (Exception e) {
			System.out.println("序列化拷贝失败");
			return null;
		}finally {
			try {
				bos.close();
				oos.close();
				bis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
