// Interface for sound behavior
interface Soundable {
    void makeSound();
}

// Abstract class for basic animal properties and incomplete eat behavior
abstract class Animal {
    protected String name;
    protected String habitat;

    public Animal(String name, String habitat) {
        this.name = name;
        this.habitat = habitat;
    }

    public abstract void eat();
}

// Concrete class Dog extends Animal and implements Soundable
class Dog extends Animal implements Soundable {
    public Dog(String name, String habitat) {
        super(name, habitat);
    }

    @Override
    public void eat() {
        System.out.println(name + " eats in the " + habitat + " (likes bones).");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof woof!");
    }
}

// Test class for demonstration
public class TestZoology {
    public static void main(String[] args) {
        Dog d = new Dog("Buddy", "house");
        d.eat();
        d.makeSound();
    }
}
