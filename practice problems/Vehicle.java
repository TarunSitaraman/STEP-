import java.util.UUID;

public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;
    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Generic";
        this.model = "Standard";
        this.year = 2000;
        this.engineType = "Petrol";
        this.registrationNumber = UUID.randomUUID().toString();
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = UUID.randomUUID().toString();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return brand + " " + model + " (" + year + "), Engine: " + engineType + ", Reg#: " + registrationNumber + ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Engine Type: " + engineType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Running: " + isRunning);
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String reg) { this.registrationNumber = reg; }
    public boolean isRunning() { return isRunning; }
}

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType, int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car startup sequence initiated");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("Honda", "Civic", 2023, "Hybrid", 4, "Hybrid", "Automatic");

        car1.displaySpecs();
        System.out.println(car1.getVehicleInfo());
        car1.start();
        car1.openTrunk();
        car1.playRadio();
        car1.stop();

        car2.displaySpecs();
        System.out.println(car2.getVehicleInfo());
        car2.start();
        car2.stop();

        System.out.println("Brand via protected: " + car2.brand);

        Vehicle v = new Car("Toyota", "Corolla", 2024, "Gasoline", 4, "Gasoline", "CVT");
        v.start();
        v.displaySpecs();

        if (v instanceof Car) {
            ((Car) v).playRadio();
        }
    }
}
