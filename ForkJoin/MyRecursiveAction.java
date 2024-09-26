package ForkJoin;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
	private final int s;
	
	public MyRecursiveAction(int s) {
		this.s = s;
	}
	
	protected void compute() {
		System.out.println(Thread.currentThread().getName());
		if (s % 2 == 0) {
			MyRecursiveAction ra1 = new MyRecursiveAction(s / 2);
			MyRecursiveAction ra2 = new MyRecursiveAction(s / 2);
			
			ra1.fork();
			ra2.fork();
		} else {
			for (int i = 0; i < s; i++) {
				System.out.println(i);
			}
		}
	}
}
