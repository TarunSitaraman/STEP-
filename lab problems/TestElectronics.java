// Interface for connectivity feature
interface Connectable {
    void connect();
}

// Abstract class for shared device structure
abstract class Device {
    protected String brand;
    protected String model;

    public Device(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // Abstract method for device power-on logic
    public abstract void powerOn();
}

// Concrete subclass: Smartphone
class Smartphone extends Device implements Connectable {
    private String os;

    public Smartphone(String brand, String model, String os) {
        super(brand, model);
        this.os = os;
    }

    @Override
    public void powerOn() {
        System.out.println("Powering on " + brand + " " + model + " (" + os + ").");
    }

    @Override
    public void connect() {
        System.out.println("Connecting " + brand + " " + model + " to network.");
    }
}

// Demonstration class
public class TestElectronics {
    public static void main(String[] args) {
        Smartphone s = new Smartphone("Samsung", "Galaxy S24", "Android");
        s.powerOn();
        s.connect();
    }
}
