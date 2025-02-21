import java.util.concurrent.*;

// A simple example to show the difference between Callable and Runnable
public class Question_1 {
    public static void main(String[] args) {
        TaskCallable taskCallable = new TaskCallable();

        // You can't pass a Callable directly to a Thread,
        // so we use an ExecutorService to handle its execution
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> result = service.submit(taskCallable);

        try {
            // This will wait for the Callable task to finish and return the result
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // Now let's try using a Runnable
        TaskRunnable taskRunnable = new TaskRunnable();

        // We can run a Runnable by passing it directly to a Thread
        new Thread(taskRunnable).start();

        // Or we can use the ExecutorService just like we did for Callable
        service.execute(taskRunnable);

        // Always remember to shut down the ExecutorService when done
        service.shutdown();
    }
}

// Callable allows returning a value and can throw checked exceptions
class TaskCallable implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Thread.sleep(2000); // Simulating some time-consuming task
        return "Response from Callable";
    }
}

// Runnable is simpler—it just runs but doesn’t return a result
class TaskRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Executing Runnable Task");
    }
}
