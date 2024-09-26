package Thread;
import java.util.List;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		List<Thread> l = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new MyRunnable(i * 20));
			l.add(t);
			t.run();
		}

		// 작업 수행이 완료되길 기다려야 한다면 join() 메서드를 사용한다.
		for (int i = 0; i < 5; i++) {
			Thread t = l.get(i);
			t.join();
		}
    }
}
