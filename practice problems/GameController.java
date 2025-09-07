public class GameController {
    // TODO: Instance variables for controller configuration
    private String controllerBrand;
    private String connectionType;
    private boolean hasVibration;
    private int batteryLevel;
    private double sensitivity;

    public GameController() {
        controllerBrand = "GenericPad";
        connectionType = "USB";
        hasVibration = true;
        batteryLevel = 100;
        sensitivity = 1.0;
    }

    public GameController(String controllerBrand, String connectionType, boolean hasVibration, int batteryLevel,
            double sensitivity) {
        this.controllerBrand = controllerBrand;
        this.connectionType = connectionType;
        this.hasVibration = hasVibration;
        this.batteryLevel = batteryLevel;
        this.sensitivity = sensitivity;
        if (batteryLevel < 0) {
            this.batteryLevel = 0;
        } else if (batteryLevel > 100) {
            this.batteryLevel = 100;
        } else {
            this.batteryLevel = batteryLevel;
        }
    }

    public GameController(String brand, String connectionType) {
        this.controllerBrand = brand;
        this.connectionType = connectionType;
        this.hasVibration = true;
        this.batteryLevel = 100;
        this.sensitivity = 1.0;
    }

    public void calibrateController() {
        System.out.println("Calibrating " + controllerBrand + "controller...");
    }

    public void displayConfiguration() {
        System.out.println("Controller Brand: " + controllerBrand);
        System.out.println("Connection Type: " + connectionType);
        System.out.println("Vibration Enabled: " + hasVibration);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Sensitivity: " + sensitivity);
    }

    public void testVibration() {
        if (hasVibration) {
            System.out.println("*BUZZ* Vibration test successful!");
        } else {
            System.out.println("Vibration disabled on this controller.");
        }
    }

    public static void main(String[] args) {
        GameController defaultController = new GameController();
        GameController customController = new GameController("ProGamer", "Bluetooth", true, 85, 1.5);
        GameController simpleController = new GameController("ArcadeMaster", "USB");

        System.out.println("=== DEFAULT CONTROLLER ===");
        defaultController.displayConfiguration();
        defaultController.calibrateController();
        defaultController.testVibration();

        System.out.println("\n=== CUSTOM CONTROLLER ===");
        customController.displayConfiguration();
        customController.calibrateController();
        customController.testVibration();

        System.out.println("=== SIMPLE CONTROLLER ===");
        simpleController.displayConfiguration();
        simpleController.calibrateController();
        simpleController.testVibration();
    }
}