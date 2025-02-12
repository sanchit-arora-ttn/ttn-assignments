import java.util.List;
import java.util.Map;
import java.util.Set;


public class Question_3 {
    public static void main(String[] args) {
        List<String> list = List.of("Rohit","Pawan","Sanchit");
        System.out.println(list);

        Set<Integer> integerSet = Set.of(1,2,3,4,5,6,7);
        System.out.println(integerSet);

        Map<String,Integer> salaryMap = Map.of("Sanchit",200000,"Krishna",150000);
        System.out.println(salaryMap);

    }
}