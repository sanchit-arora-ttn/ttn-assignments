import java.util.Scanner;

// Demonstrates the usage of the 'volatile' keyword in Java
public class Question_3 {
    public static void main(String[] args) {
        VolatileTask thread = new VolatileTask();
        thread.start();

        // Wait for user input to stop the thread
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        thread.stopPrinting();
    }
}

// Thread class demonstrating the effect of 'volatile' on shared variable visibility
class VolatileTask extends Thread {
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            System.out.println("Printing until Enter is pressed...");
        }
    }

    // Method to stop the thread by updating the volatile variable
    public void stopPrinting() {
        isRunning = false;
    }
}
