package ThreadException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionTest {

	public static void main(String[] args) {
//		Thread.setDefaultUncaughtExceptionHandler((t,e)->{
//			System.out.println(t.currentThread().getName()+"�׳��쳣  " +e.getMessage());
//			e.printStackTrace();
//		});
//		new Thread(()->{
//			System.out.println(1/0);
//		},"�쳣�߳�1").start();
		
		Pattern p = Pattern.compile("[1-9]");
		Matcher matcher = p.matcher("ddd1256ff");
		System.out.println(matcher.replaceAll("h"));
		System.out.println(matcher.replaceAll(""));
		
	}

}
