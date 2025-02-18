
class RunnableClass implements Runnable {
    @Override
    public void run() {
        System.out.println("Entering the RunnableClass thread");
        // doing some work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting the RunnableClass thread ");
    }
}

class ThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("Entering the ThreadClass thread");
        // doing some work
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exiting the ThreadClass thread ");

    }
}

public class Question_1 {
    public static void main(String[] args) {
        RunnableClass runnable = new RunnableClass();
        Thread t1 = new Thread(runnable, "t1");

        ThreadClass t2 = new ThreadClass();

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main thread execution completed.");
    }
}