import java.util.concurrent.locks.ReentrantLock;

// This program demonstrates how to prevent deadlocks using ReentrantLock
public class Question_2 {
    public static void main(String[] args) {
        // Using ReentrantLock instead of Object locks to avoid deadlock
        ReentrantLock lock1 = new ReentrantLock();
        ReentrantLock lock2 = new ReentrantLock();

        // First thread tries to acquire lock1 first, then lock2
        Thread thread1 = new Thread(() -> {
            if (lock1.tryLock()) { // Try acquiring the first lock
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                    System.out.println(Thread.currentThread().getName() + " trying to acquire lock2");
                    if (lock2.tryLock()) { // Try acquiring the second lock
                        try {
                            System.out.println(Thread.currentThread().getName() + " acquired lock2");
                        } finally {
                            lock2.unlock(); // Release lock2
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " couldn't acquire lock2");
                    }
                } finally {
                    lock1.unlock(); // Release lock1
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " couldn't acquire lock1");
            }
        }, "Thread-1");

        // Second thread tries to acquire lock2 first, then lock1
        Thread thread2 = new Thread(() -> {
            if (lock2.tryLock()) { // Try acquiring the second lock first
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    System.out.println(Thread.currentThread().getName() + " trying to acquire lock1");
                    if (lock1.tryLock()) { // Try acquiring the first lock
                        try {
                            System.out.println(Thread.currentThread().getName() + " acquired lock1");
                        } finally {
                            lock1.unlock(); // Release lock1
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " couldn't acquire lock1");
                    }
                } finally {
                    lock2.unlock(); // Release lock2
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " couldn't acquire lock2");
            }
        }, "Thread-2");

        // Start both threads
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
