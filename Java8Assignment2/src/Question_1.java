import java.lang.reflect.Array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.Predicate;

public class Question_1 {
    public static void main(String[] args) {
        Consumer<String> str = message->System.out.println("message"+ message);
        str.accept("hello ji");
        Supplier<Double> number = ()->Math.random();
        System.out.println("created randomised number"+ number.get());
        Predicate<Integer> isEven = num->num%2==0;
        System.out.println(isEven.test(10));
        Function<String, Integer> lengthFunction = s -> s.length();
        System.out.println(lengthFunction.apply("Hello"));

    }
}
