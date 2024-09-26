package ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
		ForkJoinPool p = new ForkJoinPool(5);
        // 결과 값이 필요한 경우
		RecursiveTask<Integer> rt = new MyRecursiveTask(100);
		int n = p.invoke(rt);
		
        // 결과 값이 필요 없는 경우
		RecursiveAction ra = new MyRecursiveAction(100);
		p.invoke(ra);
		
        // 작업이 완료되길 기다려야 하는 경우
        // shutdown 메서드의 경우 진행 중인 스레드가 끝나면 종료 되므로 사용에 주의한다.
		p.awaitTermination(5, TimeUnit.SECONDS);
    }
}