// Base sealed class
sealed abstract class Transport permits Car, Bike {
    public abstract void ignite();
}

// Final subclass extending sealed class
final class Car extends Transport {
    @Override
    public void ignite() {
        System.out.println("Car is Igniting");
    }
}

final class Bike extends Transport {
    @Override
    public void ignite() {
        System.out.println("Bike is Igniting");
    }
}

public class Question_4 {
    public static void main(String[] args) {
        Transport car = new Car();
        Transport bike = new Bike();
        car.ignite();
        bike.ignite();
    }
}
