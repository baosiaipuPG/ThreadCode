package com.pys.classloader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader{
	//Ĭ�ϵ�class���·��
	 private final static Path DEFAULT_CLASS_DIR = Paths.get("F://eclipse-jee-2018-12-R-win32-x86_64","ClassLoader");
	 private final Path classDir;
	 //ʹ��Ĭ��·��
	 public MyClassLoader() {
		 super();
		 this.classDir=DEFAULT_CLASS_DIR;
	 }
	 //����ָ��·��
	 public MyClassLoader(String classDir) {
		 super();
		 this.classDir=Paths.get(classDir);
	 }
	 //����ָ��·��,ָ����������
	 public MyClassLoader(String classDir,ClassLoader parent) {
		 super(parent);
		 this.classDir=Paths.get(classDir);
	 }
	 
	 @Override
	 protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classBytes = this.readClassBytes(name);
		if(classBytes == null || classBytes.length==0) {
			throw new ClassNotFoundException("can not loade the class "+name);
		}
		return this.defineClass(name,classBytes, 0,classBytes.length);
	}
	 //��class�ļ������ڴ�
	private byte[] readClassBytes(String name) throws ClassNotFoundException {
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
		if(!classFullPath.toFile().exists()) {
			throw new ClassNotFoundException("the class "+name+" not found");
		}
		//try() �����Ķ�����ʹ������Զ��ر�  ����дfinally�ر�
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			Files.copy(classFullPath, baos);
			return baos.toByteArray();
		}catch (IOException e) {
			throw new ClassNotFoundException("loade the class "+name+" error",e);
		}
	}
	@Override
	public String toString() {
		return "my ClassLoader ������"+String.class.getClassLoader();
	}
}
