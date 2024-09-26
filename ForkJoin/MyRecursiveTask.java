package ForkJoin;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
	private final int s;
	
	public MyRecursiveTask(int s) {
		this.s = s;
	}
	
	protected Integer compute() {
		if (s % 2 == 0) {
			 
			MyRecursiveTask rt1 = new MyRecursiveTask(s / 2);
			MyRecursiveTask rt2 = new MyRecursiveTask(s / 2);
			
			rt1.fork();
			rt2.fork();
			
			int r = 0;
			
			r += rt1.join();
			r += rt2.join();
			
			return r;
		} else {
			int r = 0;
			for (int i = 0; i < s; i++) {
				r++;
			}
			return r;
		}
	}
}
