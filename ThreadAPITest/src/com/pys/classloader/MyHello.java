package com.pys.classloader;

public class MyHello {
	private static int x=10;
	private static String s ="d";
	static {
		System.out.println("hello world class is my classLoader initialized112");
	}
	public String getString() {
		return " my classLoader 112 success"+String.class.getClassLoader();
	}
	 
}
