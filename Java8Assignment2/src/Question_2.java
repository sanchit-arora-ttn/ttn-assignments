
interface Drinks{
    default void water(){
        System.out.println("i have water in me");
    }

}
class FizzyDrinks implements Drinks{

        }

interface Vehicle {
    static void stop() {
        System.out.println("Vehicle is stopping...");
    }
}



public class Question_2 {
    public static void main(String[] args) {
        FizzyDrinks drink1 = new FizzyDrinks();
        drink1.water();
        Vehicle.stop();

    }
}
