public class Car {
    private String brand;
    private String model;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car[brand=" + brand + ", model=" + model + ", price=" + price + "]";
    }
}

class CarDemo {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 25000.0);

        // Print object (calls toString())
        System.out.println(car);

        // Print class name using getClass().getName()
        System.out.println("Class name: " + car.getClass().getName());
    }
}
