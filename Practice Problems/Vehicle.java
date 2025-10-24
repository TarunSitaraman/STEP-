public class Vehicle {
    private String registrationNo;
    private String type;
    private double ratePerDay;
    
    public Vehicle(String registrationNo, String type, double ratePerDay) {
        this.registrationNo = registrationNo;
        this.type = type;
        this.ratePerDay = ratePerDay;
    }
    
    @Override
    public String toString() {
        return "Vehicle: " + registrationNo + ", Type: " + type + ", Rate: $" + ratePerDay + "/day";
    }
    
    public String getRegistrationNo() {
        return registrationNo;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRatePerDay() {
        return ratePerDay;
    }
}

class VehicleRental {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println(vehicle1);
        
        Vehicle vehicle2 = new Vehicle("KA05CD5678", "SUV", 2000);
        System.out.println(vehicle2);
        
        System.out.println("\nComparison:");
        System.out.println("Registration: " + vehicle1.getRegistrationNo() + " vs " + vehicle2.getRegistrationNo());
        System.out.println("Type: " + vehicle1.getType() + " vs " + vehicle2.getType());
        System.out.println("Rate: $" + vehicle1.getRatePerDay() + " vs $" + vehicle2.getRatePerDay());
    }
}
