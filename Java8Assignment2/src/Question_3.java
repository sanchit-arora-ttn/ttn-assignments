import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.List;

public class Question_3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,1,6,5,7,8);
        int sum = numbers.stream()
                         .filter(num->num>5)
                         .mapToInt(Integer::intValue)
                         .sum();
        System.out.println("Sum of numbers greater than 5: " + sum);
    }
}
