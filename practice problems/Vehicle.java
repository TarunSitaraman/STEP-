public class Vehicle {
    protected String make, model;
    protected int year;
    protected double fuelLevel;
    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }
    public void startVehicle() {
        System.out.println(make + " " + model + " started.");
    }
    public void stopVehicle() {
        System.out.println(make + " " + model + " stopped.");
    }
    public void refuel(double amount) {
        if (amount > 0) {
            fuelLevel += amount;
            System.out.println("Refueled " + amount + " liters. Current fuel level: " + fuelLevel + " liters.");
        } else {
            System.out.println("Refuel amount must be positive.");
        }
    }
    public void displayVehicleInfo() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + " liters");
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", 2020, 50);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", 2019, 40);
        vehicle1.startVehicle();
        vehicle1.displayVehicleInfo();  
        vehicle1.refuel(10);
        vehicle1.stopVehicle();
        vehicle2.startVehicle();
        vehicle2.displayVehicleInfo();
        vehicle2.refuel(5);
        vehicle2.stopVehicle();
        
        Vehicle[] vehicles = {vehicle1, vehicle2};
        for (Vehicle v : vehicles) {
            v.displayVehicleInfo();
        }   
    }
}