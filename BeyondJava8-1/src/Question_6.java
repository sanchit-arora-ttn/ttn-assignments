
import java.util.Scanner;

public class Question_6 {
    public enum OrderStatus {
        PENDING,
        PROCESSING,
        SHIPPED,
        DELIVERED,
        CANCELLED,
        REFUNDED
    }
    public static void main(String[] args) {
        Scanner scn =new Scanner(System.in);
        //taken the input for your status you want to check
        System.out.println("Enter the status of your order");
        String status= scn.nextLine().trim().toUpperCase();
        // converting string into enum constant
        OrderStatus orderStatus = OrderStatus.valueOf(status);
        System.out.println(processOrderStatus(orderStatus));

    }
    public static String processOrderStatus(OrderStatus status) {
        return switch (status) {
            case PENDING -> "Order is awaiting confirmation.";
            case PROCESSING -> "Order is being prepared.";
            case SHIPPED -> "Order has been dispatched.";
            case DELIVERED -> "Order has been successfully delivered.";
            case CANCELLED -> "Order has been canceled.";
            case REFUNDED -> {
                // writing logic to refund
                int  refund = 100;
                // did this to write yield
                yield "Refund has been issued for the order.";
            }
        };
    }
}