public class SmartDevice {
    private String deviceName;
    private String location;
    private boolean isOnline;
    private double powerConsumption;
    private String[] connectedDevices;
    private int connectionCount;

    // Constructor matches parameter names to field names, uses 'this' for
    // disambiguation
    public SmartDevice(String deviceName, String location, boolean isOnline, double powerConsumption) {
        this.deviceName = deviceName;
        this.location = location;
        this.isOnline = isOnline;
        this.powerConsumption = powerConsumption;
        this.connectedDevices = new String[5]; // Array size fixed to 5
        this.connectionCount = 0;
    }

    // Method for location update using 'this' for assignment
    public void updateLocation(String location) {
        this.location = location; // Disambiguation using 'this'
        System.out.println(this.deviceName + " moved to " + this.location);
    }

    // Method for power consumption update with 'this' keyword (disambiguation)
    public void updatePowerConsumption(double powerConsumption) {
        this.powerConsumption = powerConsumption;
        System.out.println("Power consumption updated for " + this.deviceName);
    }

    // Method enabling method chaining by returning 'this'
    public SmartDevice setOnline(boolean isOnline) {
        this.isOnline = isOnline;
        return this;
    }

    public SmartDevice connectToDevice(String deviceName) {
        if (this.connectionCount < this.connectedDevices.length) {
            this.connectedDevices[this.connectionCount] = deviceName;
            this.connectionCount++;
            System.out.println(this.deviceName + " connected to " + deviceName);
        }
        return this; // Supports chaining
    }

    // Method with 'this' keyword for field access and disambiguation
    public SmartDevice rename(String deviceName) {
        String oldName = this.deviceName;
        this.deviceName = deviceName;
        System.out.println("Device renamed from " + oldName + " to " + this.deviceName);
        return this;
    }

    // Info display method using 'this' throughout
    public void displayDeviceInfo() {
        System.out.println("\n=== " + this.deviceName + " INFO ===");
        System.out.println("Location: " + this.location);
        System.out.println("Status: " + (this.isOnline ? "Online" : "Offline"));
        System.out.println("Power: " + this.powerConsumption + "W");
        System.out.println("Connections: " + this.connectionCount);
        for (int i = 0; i < this.connectionCount; i++) {
            System.out.println(" -> " + this.connectedDevices[i]);
        }
    }

    // Method that calls other class methods using 'this'
    public void performInitialSetup() {
        this.setOnline(true);
        System.out.println(this.deviceName + " initial setup completed");
    }

    // main method: demonstration of 'this' usage and method chaining
    public static void main(String[] args) {
        System.out.println("=== SMART HOME DEVICE NETWORK ===");
        // Create devices with parameter names matching field names, using 'this' for
        // initialization
        SmartDevice device = new SmartDevice("Living Room Speaker", "Living Room", false, 60.5);

        // Method chaining example
        device.setOnline(true)
                .connectToDevice("Alexa")
                .rename("Kitchen Hub")
                .connectToDevice("Smart Light")
                .connectToDevice("Air Purifier");

        // Demonstrate update methods using 'this'
        device.updateLocation("Kitchen");
        device.updatePowerConsumption(45.0);

        // Display device info
        device.displayDeviceInfo();

        // Perform initial setup
        device.performInitialSetup();
    }
}
