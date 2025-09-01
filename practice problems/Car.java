public class Car {
    String brand, model, color;
    int year;
    boolean isRunning;

    public void Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started.");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped.");
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Is Running: " + isRunning);
    }

    public int getAge() {
        return 2025 - year; 
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2018, "Red");
        Car car2 = new Car("Honda", "Civic", 2020, "Blue");
        Car car3 = new Car("Ford", "Mustang", 2015, "Black");

        car1.startEngine();
        car1.displayInfo();
        System.out.println("Age: " + car1.getAge() + " years\n");

        car2.startEngine();
        car2.displayInfo();
        car2.stopEngine();
        System.out.println("Age: " + car2.getAge() + " years\n");

        car3.displayInfo();
        System.out.println("Age: " + car3.getAge() + " years\n");
    }
}
