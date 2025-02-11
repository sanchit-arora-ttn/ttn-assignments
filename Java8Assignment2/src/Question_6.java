import java.time.LocalDate;
import java.util.Scanner;
import java.time.ZonedDateTime;
import java.time.ZoneId;
public class Question_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date(yyyy-mm-dd)");
        LocalDate date1 = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter the 2nd date(yyyy-mm-dd)");
        LocalDate date2 = LocalDate.parse(scanner.nextLine());
        if (date1.isBefore(date2)) {
            System.out.println("The first date occurs before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date occurs after the second date.");
        } else {
            System.out.println("Both dates are the same.");
        }

        scanner.close();
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Current UTC Time: " + utcTime);

        // Current date and time in New York (America/New_York)
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Current New York Time: " + newYorkTime);

        // Current date and time in India (Asia/Kolkata)
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current India Time: " + indiaTime);

    }
}