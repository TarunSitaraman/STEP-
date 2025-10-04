abstract class Vehicle {
    String vehicleID;
    Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }
    abstract void dispatch();
}

class Bus extends Vehicle {
    String route;
    int passengerCapacity;
    Bus(String vehicleID, String route, int passengerCapacity) {
        super(vehicleID);
        this.route = route;
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    void dispatch() {
        System.out.println("Bus " + vehicleID + " dispatched on Route: " + route);
        System.out.println("Passenger Capacity: " + passengerCapacity);
    }
}

class Taxi extends Vehicle {
    double distanceKm;
    double farePerKm;
    Taxi(String vehicleID, double distanceKm, double farePerKm) {
        super(vehicleID);
        this.distanceKm = distanceKm;
        this.farePerKm = farePerKm;
    }
    @Override
    void dispatch() {
        double fare = distanceKm * farePerKm;
        System.out.println("Taxi " + vehicleID + " dispatched for " + distanceKm + " km");
        System.out.println("Total Fare: ₹" + fare);
    }
}

class Train extends Vehicle {
    String scheduleTime;
    int carCount;
    Train(String vehicleID, String scheduleTime, int carCount) {
        super(vehicleID);
        this.scheduleTime = scheduleTime;
        this.carCount = carCount;
    }
    @Override
    void dispatch() {
        System.out.println("Train " + vehicleID + " scheduled at " + scheduleTime);
        System.out.println("Car Count: " + carCount);
    }
}

class Bike extends Vehicle {
    int minutes;
    Bike(String vehicleID, int minutes) {
        super(vehicleID);
        this.minutes = minutes;
    }
    @Override
    void dispatch() {
        System.out.println("Bike " + vehicleID + " dispatched for " + minutes + " minutes (Eco-friendly trip)");
    }
}

public class CityTransportSystem {
    public static void dispatchVehicle(Vehicle v) {
        v.dispatch();
        System.out.println("---");
    }

    public static void main(String[] args) {
        Vehicle vehicle;

        vehicle = new Bus("B12", "Central Loop", 40);
        dispatchVehicle(vehicle);

        vehicle = new Taxi("T99", 15.5, 20);
        dispatchVehicle(vehicle);

        vehicle = new Train("Tr45", "14:30", 8);
        dispatchVehicle(vehicle);

        vehicle = new Bike("BK7", 22);
        dispatchVehicle(vehicle);
    }
}
