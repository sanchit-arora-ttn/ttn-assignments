import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Question_4 {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1,15).boxed().collect(Collectors.toUnmodifiableList());

        System.out.println(list);



    }
}