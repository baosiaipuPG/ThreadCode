package designPattern.prototype;

import java.io.Serializable;

public class Subject2Serializable implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", score=" + score + "]";
	}
	public Subject2Serializable(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public Subject2Serializable() {
		super();
	}
 
}
