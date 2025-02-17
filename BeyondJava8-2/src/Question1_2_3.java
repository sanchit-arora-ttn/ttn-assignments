import java.util.Objects;

record Student(int id, String name, int standard) {
    Student {
        Objects.requireNonNull(id, "id can't be null");
        Objects.requireNonNull(name, "name can't be null");
        Objects.requireNonNull(standard, "standard can't be null");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && standard == student.standard && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, standard);
    }
}

public class Question1_2_3 {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Sanchit", 12);
        Student student2 = new Student(1, "Sanchit", 12);
        Student student3 = new Student(2, "Krishna", 12);

        System.out.println(student1.equals(student2));
        System.out.println(student1.equals(student3));
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student3.hashCode());
    }
}
