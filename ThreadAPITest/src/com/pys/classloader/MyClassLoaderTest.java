package com.pys.classloader;

import java.lang.reflect.InvocationTargetException;

public class MyClassLoaderTest {
	
	public static void main(String[] args) throws ClassNotFoundException,
					InstantiationException,
					IllegalAccessException,
					NoSuchMethodException, 
					SecurityException,
					IllegalArgumentException, 
					InvocationTargetException {
		MyClassLoader myclassLoader =  new MyClassLoader();
		MyClassLoader brclass =
				new MyClassLoader("F:\\eclipse-jee-2018-12-R-win32-x86_64\\ClassLoader",null);
		Class<?> aclass= myclassLoader.loadClass("com.pys.classloader.MyHello");
		System.out.println("agetClassLoader  "+aclass.getClassLoader());
		Class<?> bclass= brclass.loadClass("com.pys.classloader.MyHello");
		System.out.println("bgetClassLoader  "+bclass.getClassLoader());
		System.out.println(bclass==aclass);
		
		//Ö¸¶¨Â·¾¶
//		MyClassLoader myclassLoader = new 
//				MyClassLoader("F:\\eclipse-jee-2018-12-R-win32-x86_64\\ClassLoader",null);
//		Object hellow = aclass.newInstance();
//		System.out.println("Object hellow  "+hellow);
//		Method we = aclass.getMethod("getString");
//		String resut = (String) we.invoke(hellow);
//		System.out.println("resut "+ resut);
		
		
	}

}
