package fork.join;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

	private int beg;
	private int end;
	
	public MyRecursiveAction(int beg, int end) {
		super();
		this.beg = beg;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end-beg>2) {
			int middle = (beg+end)/2;
			MyRecursiveAction left = new MyRecursiveAction(beg, middle);
			MyRecursiveAction right = new MyRecursiveAction(middle+1,end);
			this.invokeAll(left,right);
		}else {
			System.out.println("分解组合 "+beg+"  "+end);
		}
	}

}
