// Use iterator stream method to generate a stream
import java.util.stream.Stream;

public class Question_1 {
    public static void main(String[] args) {


        //iterate with seed , Predicate , Unary operator
        Stream<Integer> streamOfInteger = Stream
                .iterate(0,i->i<11, i->i+1);

        // can also do it like this for integers
        //       Stream<Integer> integerStream = IntStream
        //                .iterate(0, i->i<11, i->i+1).boxed();


        streamOfInteger.forEach(System.out::println);

        //can also use iterate with just seed and unary operator
        Stream.iterate(1,i-> i+2).limit(10).forEach(System.out::println);
    }
}