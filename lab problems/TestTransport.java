// Interface for maintenance behavior
interface Maintainable {
    void serviceInfo();
}

// Abstract class for Vehicle properties and behavior
abstract class Vehicle {
    protected int speed;
    protected String fuelType;

    public Vehicle(int speed, String fuelType) {
        this.speed = speed;
        this.fuelType = fuelType;
    }

    // Abstract method
    public abstract void startEngine();
}

// Concrete class Car extends Vehicle and implements Maintainable
class Car extends Vehicle implements Maintainable {
    private String model;

    public Car(int speed, String fuelType, String model) {
        super(speed, fuelType);
        this.model = model;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting engine of " + model + " (Speed: " + speed + ", Fuel: " + fuelType + ")");
    }

    @Override
    public void serviceInfo() {
        System.out.println("Service for " + model + ": Oil change every 1 year, tire rotation every 6 months.");
    }
}

// Test class for demonstration
public class TestTransport {
    public static void main(String[] args) {
        Car c = new Car(120, "Petrol", "Honda City");
        c.startEngine();
        c.serviceInfo();
    }
}
