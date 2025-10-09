// Animal interface with eat() method
interface Animal {
    void eat();
}

// Pet interface that extends Animal and adds play()
interface Pet extends Animal {
    void play();
}

// Dog class implements Pet (and the inherited Animal interface)
class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog eats bones.");
    }

    @Override
    public void play() {
        System.out.println("Dog plays fetch.");
    }
}

// Test the interface inheritance
public class TestInterfaceInheritance {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();   // from Animal interface, via Pet
        d.play();  // from Pet interface
    }
}
