package ExecutorService;
import java.util.concurrent.*;

public class MyFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> submit = executorService.submit(hello);
        System.out.println("Started!");
        
        submit.get(); // 블로킹 콜

        System.out.println("End");

        executorService.shutdown();
    }
}
