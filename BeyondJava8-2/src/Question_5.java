sealed class Base permits TypeA, TypeB, TypeC {
    void display() {
        System.out.println("Base");
    }
}

// Final child class: this type of class cannot be extended further
final class TypeA extends Base {
    @Override
    void display() {
        System.out.println("TypeA");
    }
}

// Sealed child class: this type of child class must declare classes that can further extend it
sealed class TypeB extends Base permits SubTypeB {
    @Override
    void display() {
        System.out.println("TypeB");
    }
}

// Non-sealed child class: this type of child class is open for further inheritance
non-sealed class TypeC extends Base {
    @Override
    void display() {
        System.out.println("TypeC");
    }
}

// SubTypeB is a subclass of a child sealed class that is TypeB
final class SubTypeB extends TypeB {
    @Override
    void display() {
        System.out.println("SubTypeB, parent is: TypeB, ancestor is: Base");
    }
}

public class Question_5 {
    public static void main(String[] args) {
        Base base = new Base();
        base.display();

        TypeA typeA = new TypeA();
        typeA.display();

        TypeB typeB = new TypeB();
        typeB.display();

        TypeC typeC = new TypeC();
        typeC.display();

        SubTypeB subTypeB = new SubTypeB();
        subTypeB.display();
    }
}
