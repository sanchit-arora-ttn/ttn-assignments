import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    String fullName;
    Long salary;
    String city;

    public Employee(String fullName, Long salary, String city){
        this.fullName = fullName;
        this.salary = salary;
        this.city = city;
    }
}
public class Question_5 {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ram Kumar Singh", 5000L, "Delhi");
        Employee e2 = new Employee("Sanchit Kumar Arora", 7000L, "Banglore");
        Employee e3 = new Employee("Lal Singh Chadda", 3000L, "Delhi");
        Employee e4 = new Employee("Keshav Kumar Gupta", 40000L, "Gurugaon");
        Employee e5 = new Employee("Raj Kumar Rao", 1000L, "Noida");

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);

        List<String> firstNames = list.stream().filter(ob->ob.salary < 5000L).map(ob->ob.fullName.split(" ")[0]).distinct().collect(Collectors.toList());
        System.out.println(firstNames);
    }
}