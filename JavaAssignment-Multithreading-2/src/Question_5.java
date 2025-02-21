import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// WAP to showcase the difference between shutdown() and shutdownNow().
public class Question_5 {
    public static void main(String[] args) {
        ExecutorService  executorService = Executors.newFixedThreadPool(2);
        for(int i=0;i<5 ;i++){
            int finalI = i;
            executorService.execute(()->{
                System.out.println("Executing Task"  + finalI + " (shutdown)" );
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Task " + finalI + " intreputed (shutdown)");
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //for shutdownNow
        ExecutorService  executorForShutNow = Executors.newFixedThreadPool(2);
        for(int i=0;i<5 ;i++){
            int finalI = i;
            executorForShutNow.execute(()->{
                System.out.println("Executing Task" + finalI + " for ShutDownNOw" );
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Task " + finalI + " interrupted (shutdownNow)");
                }
            });
        }
        // will throw Exception here
        executorForShutNow.shutdownNow();

    }

}