package Thread;
public class MyRunnable implements Runnable {
	private final int s;
	public MyRunnable(int s) {
		this.s = s;
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(i + s);
		}
	}
}