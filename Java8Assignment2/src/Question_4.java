import java.util.Optional;

public class Question_4 {

    public static Optional<String> getUserById(int id) {
        if (id == 1) {
            return Optional.of("Sanchit"); // Returning a valid value
        } else {
            return Optional.empty(); // No user found
        }
    }

    public static void main(String[] args) {
        int userId=2;
        Optional<String> user = getUserById(userId);
        user.ifPresent(name -> System.out.println("Hello, " + name + "!"));
    }
}
