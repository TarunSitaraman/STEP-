class SmartDevice {
    String location;

    SmartDevice(String location) {
        this.location = location;
    }

    void showStatus() {
        System.out.println(location + ": Device online.");
    }
}

class SmartClassroom extends SmartDevice {
    SmartClassroom(String location) {
        super(location);
    }

    void controlLighting(boolean state) {
        System.out.println(location + ": Classroom lights turned " + (state ? "ON" : "OFF"));
    }

    void controlAC(int temp) {
        System.out.println(location + ": AC temperature set to " + temp + "°C");
    }

    void controlProjector(boolean state) {
        System.out.println(location + ": Projector " + (state ? "activated" : "deactivated"));
    }
}

class SmartLab extends SmartDevice {
    SmartLab(String location) {
        super(location);
    }

    void manageEquipment(String equipment) {
        System.out.println(location + ": Managing lab equipment - " + equipment);
    }

    void triggerSafetySystem(boolean alert) {
        System.out.println(location + ": Safety System " + (alert ? "activated!" : "is normal"));
    }
}

class SmartLibrary extends SmartDevice {
    SmartLibrary(String location) {
        super(location);
    }

    void trackOccupancy(int count) {
        System.out.println(location + ": Current occupancy is " + count);
    }

    void checkBookAvailability(String book) {
        System.out.println(location + ": Checking if '" + book + "' is available.");
    }
}

public class CampusManagementSystem {
    public static void main(String[] args) {
        SmartDevice[] devices = {
            new SmartClassroom("Room 101"),
            new SmartLab("Biology Lab"),
            new SmartLibrary("Central Library"),
            new SmartClassroom("Room 202"),
            new SmartLab("Chemistry Lab")
        };

        for (SmartDevice device : devices) {
            device.showStatus();

            if (device instanceof SmartClassroom) {
                SmartClassroom classroom = (SmartClassroom) device;
                classroom.controlLighting(true);
                classroom.controlAC(22);
                classroom.controlProjector(false);
            } else if (device instanceof SmartLab) {
                SmartLab lab = (SmartLab) device;
                lab.manageEquipment("Microscope");
                lab.triggerSafetySystem(false);
            } else if (device instanceof SmartLibrary) {
                SmartLibrary library = (SmartLibrary) device;
                library.trackOccupancy(45);
                library.checkBookAvailability("Data Structures in Java");
            }
            System.out.println("---");
        }
    }
}
