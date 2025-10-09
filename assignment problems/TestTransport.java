// Interface for fuel behavior
interface Fuel {
    void refuel();
}

// Abstract class for vehicle structure
abstract class Vehicle {
    // Abstract method
    public abstract void start();

    // Concrete method
    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

// Car class implementing both inheritance and interface
class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car started.");
    }

    @Override
    public void refuel() {
        System.out.println("Car is refueling.");
    }
}

// Testing the solution
public class TestTransport {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();    // from Vehicle (abstract implemented by Car)
        myCar.stop();     // from Vehicle (concrete in Vehicle)
        myCar.refuel();   // from Fuel interface
    }
}
