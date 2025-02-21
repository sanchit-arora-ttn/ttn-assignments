import java.util.Random;
import java.util.concurrent.*;

// Program to return a random integer value from a thread execution using Future
public class Question_4 {
    public static void main(String[] args) {
        // Creating an ExecutorService with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submitting a Callable task that generates a random integer
        Future<Integer> futureResult = executorService.submit(() -> {
            Random random = new Random();
            return random.nextInt(100); // Generates a random number between 0-99
        });

        try {
            // Retrieving and printing the result of the computation
            System.out.println("Random Integer is: " + futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            // Shutting down the executor service
            executorService.shutdown();
        }
    }
}
