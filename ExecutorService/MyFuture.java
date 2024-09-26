package ExecutorService;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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

        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, eric));
        for(Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
