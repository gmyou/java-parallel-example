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
        
        submit.cancel(true);
        System.out.println(submit.isDone());
        submit.get(); // 블로킹 콜

        System.out.println("End");
        System.out.println(submit.isDone());
        executorService.shutdown();
    }
}
