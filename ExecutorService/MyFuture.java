package ExecutorService;
import java.util.Arrays;
import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "Java";
        };

        Callable<String> eric = () -> {
            Thread.sleep(1000L);
            return "Eric";
        };

		String s = executorService.invokeAny(Arrays.asList(hello, java, eric));
        System.out.println(s);

        executorService.shutdown();
    }
}
