class Vehicle {
    String vehicleId;
    String type; // e.g. "Bus", "Car", "Truck"
    String status; // "Available", "In Service", etc.
    int mileage;
    Vehicle(String vehicleId, String type, int mileage) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.mileage = mileage;
        this.status = "Available";
    }
}

class Driver {
    String driverId;
    String name;
    Vehicle assignedVehicle;
    Driver(String driverId, String name) {
        this.driverId = driverId;
        this.name = name;
    }
}

class FleetManager {
    Vehicle[] vehicles = new Vehicle[21];
    Driver[] drivers = new Driver[22];
    int vCount = 0, dCount = 0;

    void addVehicle(String id, String type, int mileage) {
        vehicles[vCount++] = new Vehicle(id, type, mileage);
    }
    void addDriver(String id, String name) {
        drivers[dCount++] = new Driver(id, name);
    }
    Vehicle findAvailableVehicle(String type) {
        for (int i = 0; i < vCount; i++) {
            if (vehicles[i].type.equals(type) && vehicles[i].status.equals("Available"))
                return vehicles[i];
        }
        return null;
    }
    void assignVehicleToDriver(String driverId, String type) {
        Driver dr = null;
        for (int i = 0; i < dCount; i++) if (drivers[i].driverId.equals(driverId)) dr = drivers[i];
        Vehicle v = findAvailableVehicle(type);
        if (dr != null && v != null) {
            dr.assignedVehicle = v;
            v.status = "Assigned";
            System.out.println("Assigned " + v.type + " (" + v.vehicleId + ") to " + dr.name);
        } else {
            System.out.println("Assignment failed. Check vehicle availability and driver existence.");
        }
    }
    void updateMileage(String vehicleId, int mileage) {
        for (int i = 0; i < vCount; i++)
            if (vehicles[i].vehicleId.equals(vehicleId)) vehicles[i].mileage = mileage;
    }
    void showFleetStatus() {
        System.out.println("Fleet Status:");
        for (int i = 0; i < vCount; i++) {
            System.out.println("ID: " + vehicles[i].vehicleId +
                ", Type: " + vehicles[i].type +
                ", Status: " + vehicles[i].status +
                ", Mileage: " + vehicles[i].mileage);
        }
    }
}

public class FleetApp {
    public static void main(String[] args) {
        FleetManager fm = new FleetManager();
        fm.addVehicle("V01", "Bus", 120000);
        fm.addVehicle("V02", "Truck", 80000);
        fm.addDriver("D01", "Arjun");
        fm.addDriver("D02", "Meena");

        fm.assignVehicleToDriver("D01", "Bus");
        fm.showFleetStatus();

        fm.updateMileage("V01", 122500);
        fm.showFleetStatus();
    }
}
