package com.pys.classloader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BorkerDelegateClassLoader extends ClassLoader{
	//默认的class存放路径
	 private final static Path DEFAULT_CLASS_DIR = Paths.get("F://eclipse-jee-2018-12-R-win32-x86_64","ClassLoader");
	 private final Path classDir;
	 //使用默认路径
	 public BorkerDelegateClassLoader() {
		 super();
		 this.classDir=DEFAULT_CLASS_DIR;
	 }
	 //传入指定路径
	 public BorkerDelegateClassLoader(String classDir) {
		 super();
		 this.classDir=Paths.get(classDir);
	 }
	 //传入指定路径,指定父加载器
	 public BorkerDelegateClassLoader(String classDir,ClassLoader parent) {
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
	 //将class文件读入内存
	private byte[] readClassBytes(String name) throws ClassNotFoundException {
		String classPath = name.replace(".", "/");
		Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
		if(!classFullPath.toFile().exists()) {
			throw new ClassNotFoundException("the class "+name+" not found");
		}
		//try() 创建的对象在使用完后自动关闭  不用写finally关闭
		try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
			Files.copy(classFullPath, baos);
			return baos.toByteArray();
		}catch (IOException e) {
			throw new ClassNotFoundException("loade the class "+name+" error",e);
		}
	}
	@Override
	public String toString() {
		return "my BorkerDelegateClassLoader 加载器" +String.class.getClassLoader();
	}
	
	@Override
	protected Class<?> loadClass(String name,boolean resolve) throws ClassNotFoundException{
		synchronized (getClassLoadingLock(name)) {
			Class<?> klass = findLoadedClass(name);
			if(klass==null) {
				if(name.startsWith("java.") || name.startsWith("javax")) {
					try {
						klass = getSystemClassLoader().loadClass(name);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}else {
					try {
						klass = this.findClass(name);
					} catch (Exception e) {
						// TODO: handle exception
					}
					if(klass==null) {
						if(getParent()!=null) {
							klass = getParent().loadClass(name);
						}else {
							klass = getSystemClassLoader().loadClass(name);
						}
					}
				}
			}
			if(klass==null) {
				throw new ClassNotFoundException("the class "+name+" not found");
			}
			if(resolve) {
				resolveClass(klass);
			}
			return klass;
		}
	}
}
