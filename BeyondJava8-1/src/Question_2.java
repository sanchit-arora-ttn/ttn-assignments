import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class Question_2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,9,11,15,15,17);

        Optional<Integer> optional = list.stream().filter(e->e>6).findAny();

        Stream<Integer> streamOfIntegers = optional.stream();

        streamOfIntegers.forEach(System.out::println);


        // you can also just simply do:
        //Optional <Integer> optionalInteger = Optional.of(1);
        //Stream<Integer> integerStream = optionalInteger .stream();

    }
}