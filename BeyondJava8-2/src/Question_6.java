import java.util.*;

public class Question_6 {
    public static void main(String[] args) {
        SequencedSet<Integer> set = new LinkedHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);//it will be ignored

        System.out.println("Orginal set is : " + set + "\n");

        //add first and last
        set.addFirst(0);
        set.addLast(5);
        System.out.println("First and last elements added: " + set + "\n") ;

        //remove first and last
        set.removeFirst();
        set.removeLast();
        System.out.println("First and last elements removed: " + set + "\n");

        //get first and last from set
        System.out.println("First element in the set is : " + set.getFirst());
        System.out.println("Last element in the set is : " + set.getLast()+"\n");

        //reverse the set
        System.out.println("Set in Reverse order : " + set.reversed());

    }
}