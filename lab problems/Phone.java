public class Phone {
    String brand;
    String model;

    public Phone(String brand, String model) {
        System.out.println("Phone constructor called");
        this.brand = brand;
        this.model = model;
    }
}

class SmartPhone extends Phone {
    String operatingSystem;

    public SmartPhone(String brand, String model, String operatingSystem) {
        super(brand, model); // Calls Phone constructor
        System.out.println("SmartPhone constructor called");
        this.operatingSystem = operatingSystem;
    }
}

class Main {
    public static void main(String[] args) {
        // Constructor chaining demonstration
        SmartPhone phone1 = new SmartPhone("Samsung", "Galaxy S24", "Android");
        System.out.println(phone1.brand + ", " + phone1.model + ", " + phone1.operatingSystem);

        SmartPhone phone2 = new SmartPhone("Apple", "iPhone 15", "iOS");
        System.out.println(phone2.brand + ", " + phone2.model + ", " + phone2.operatingSystem);
    }
}
