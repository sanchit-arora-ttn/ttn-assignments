public class Question_2 {

    // Demonstrates thread synchronization using synchronized methods and blocks
    private int count = 0;

    public static void main(String[] args) {
        Question_2 instance = new Question_2();

        Thread thread1 = new Thread(() -> {
            instance.increment();
            instance.decrement();
        }, "Thread-1");

        Thread thread2 = new Thread(() -> {
            instance.increment();
            instance.decrement();
        }, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count value: " + instance.count);
    }

    // Synchronized method to prevent race conditions when incrementing count
    public synchronized void increment() {
        System.out.println(Thread.currentThread().getName() + " - Entering increment method");
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting increment method");
    }

    // Synchronized block for finer control over synchronization when decrementing count
    public void decrement() {
        System.out.println(Thread.currentThread().getName() + " - Entering decrement method");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                count--;
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Exiting decrement method");
    }
}

