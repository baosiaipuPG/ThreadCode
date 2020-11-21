package fork.join;

import java.util.concurrent.RecursiveTask;

public class MyRecusiveTaskString extends RecursiveTask<Integer> {
	private int beg;
	private int end;
	public MyRecusiveTaskString(int beg, int end) {
		super();
		this.beg = beg;
		this.end = end;
	}
	@Override
	protected Integer compute() {
		if (end - beg > 2) {
			int middle = (beg + end) / 2;
			MyRecusiveTaskString left = new MyRecusiveTaskString(beg, middle);
			MyRecusiveTaskString right = new MyRecusiveTaskString(middle + 1, end);
			this.invokeAll(left, right);
			return left.join() + right.join();
		} else {
			System.out.println("分解组合 " + beg + "  " + end);
			Integer s = 0;
			for (int i = beg; i <= end; i++) {
				s +=i;
			}
			return s;
		}
	}
}
