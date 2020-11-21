package fork.join;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer>{

	@Override
	protected Integer compute() {
		System.out.println(Thread.currentThread().getName()+"Ö´ÐÐ  MyRecursiveTask");
		String s = null;
		s.toString();
		return 100;
	}

}
