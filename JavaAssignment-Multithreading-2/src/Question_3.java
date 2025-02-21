import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Demonstrating different types of ThreadPool Executors in Java
public class Question_3 {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();
        for (int id = 0; id < 5; id++) {
            taskList.add(new Task(id));
        }

        // Running tasks with a SingleThreadExecutor (executes tasks sequentially in a single thread)
        System.out.println("Single Thread Executor");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        executeTasks(singleThreadExecutor, taskList);

        // Running tasks with a CachedThreadPool (creates new threads as needed, reuses idle threads)
        System.out.println("Cached Thread Pool");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        executeTasks(cachedThreadPool, taskList);

        // Running tasks with a FixedThreadPool(3) (limits the number of threads to 3)
        System.out.println("Fixed Thread Pool (3)");
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        executeTasks(fixedThreadPool, taskList);
    }

    // Helper method to execute tasks and print results
    private static void executeTasks(ExecutorService executor, List<Task> tasks) {
        try {
            List<Future<String>> futures = executor.invokeAll(tasks);
            for (Future<String> future : futures) {
                // Waiting for each task to complete and printing the result
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown(); // Ensure executor shuts down after execution
        }
    }
}

// Task class implementing Callable to return a result after execution
class Task implements Callable<String> {
    private final int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Task " + id + " running in " + Thread.currentThread().getName());
        Thread.sleep(1000); // Simulating some processing time
        return "Completed Task " + id;
    }
}
