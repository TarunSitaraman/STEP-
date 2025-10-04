class SmartDevice {
    String deviceName;

    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    void basicStatus() {
        System.out.println(deviceName + ": Online and ready");
    }
}

class SmartTV extends SmartDevice {
    SmartTV(String deviceName) { super(deviceName); }
    void setChannel(int channel) {
        System.out.println(deviceName + ": Channel set to " + channel);
    }
    void adjustVolume(int value) {
        System.out.println(deviceName + ": Volume set to " + value);
    }
    void openApp(String app) {
        System.out.println(deviceName + ": Opened streaming app " + app);
    }
}

class SmartThermostat extends SmartDevice {
    SmartThermostat(String deviceName) { super(deviceName); }
    void setTemperature(double temp) {
        System.out.println(deviceName + ": Temperature set to " + temp + "°C");
    }
    void setHumidity(int humidity) {
        System.out.println(deviceName + ": Humidity set to " + humidity + "%");
    }
    void setEnergySaving(boolean enabled) {
        System.out.println(deviceName + ": Energy saving " + (enabled ? "ON" : "OFF"));
    }
}

class SmartSecurity extends SmartDevice {
    SmartSecurity(String deviceName) { super(deviceName); }
    void activateAlarm() {
        System.out.println(deviceName + ": Alarm activated.");
    }
    void showCameraFeed() {
        System.out.println(deviceName + ": Showing live camera feed.");
    }
    void openAccessControl() {
        System.out.println(deviceName + ": Access control panel open.");
    }
}

class SmartKitchenAppliance extends SmartDevice {
    SmartKitchenAppliance(String deviceName) { super(deviceName); }
    void setCookingTime(int minutes) {
        System.out.println(deviceName + ": Cooking time set to " + minutes + " minutes.");
    }
    void setCookingTemp(int temp) {
        System.out.println(deviceName + ": Cooking temperature set to " + temp + "°C");
    }
    void selectRecipe(String recipe) {
        System.out.println(deviceName + ": Recipe selected - " + recipe);
    }
}

public class HomeAutomationSystem {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartTV("Living Room TV"),
            new SmartThermostat("Main Thermostat"),
            new SmartSecurity("Front Door Security"),
            new SmartKitchenAppliance("Smart Oven")
        };

        for (SmartDevice device : devices) {
            device.basicStatus();
            if (device instanceof SmartTV) {
                SmartTV tv = (SmartTV) device;
                tv.setChannel(8);
                tv.adjustVolume(15);
                tv.openApp("Netflix");
            } else if (device instanceof SmartThermostat) {
                SmartThermostat thermo = (SmartThermostat) device;
                thermo.setTemperature(23);
                thermo.setHumidity(45);
                thermo.setEnergySaving(true);
            } else if (device instanceof SmartSecurity) {
                SmartSecurity sec = (SmartSecurity) device;
                sec.activateAlarm();
                sec.showCameraFeed();
                sec.openAccessControl();
            } else if (device instanceof SmartKitchenAppliance) {
                SmartKitchenAppliance kitchen = (SmartKitchenAppliance) device;
                kitchen.setCookingTime(30);
                kitchen.setCookingTemp(180);
                kitchen.selectRecipe("Grilled Paneer");
            }
            System.out.println("---");
        }
    }
}
