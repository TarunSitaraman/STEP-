public class AudioMixer {
    private String mixerModel;
    private int numberOfChannels;
    private boolean hasBluetoothConnectivity;
    private double maxVolumeDecibels;
    private String[] connectedDevices;
    private int deviceCount;

    // No-argument constructor using this() chaining
    public AudioMixer() {
        this("StandardMix-8", 8); // Calls the two-parameter constructor with defaults
    }

    // Two-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels) {
        this(mixerModel, numberOfChannels, false); // Calls three-parameter constructor with bluetooth disabled
    }

    // Three-parameter constructor using this() chaining
    public AudioMixer(String mixerModel, int numberOfChannels, boolean hasBluetoothConnectivity) {
        this(mixerModel, numberOfChannels, hasBluetoothConnectivity, 120.0); // Calls the main constructor with default max volume
    }

    // Main constructor - all parameters
    public AudioMixer(String mixerModel, int numberOfChannels,
                      boolean hasBluetoothConnectivity, double maxVolumeDecibels) {
        this.mixerModel = mixerModel;
        this.numberOfChannels = numberOfChannels;
        this.hasBluetoothConnectivity = hasBluetoothConnectivity;
        this.maxVolumeDecibels = maxVolumeDecibels;
        this.connectedDevices = new String[numberOfChannels]; // Array size based on channels
        this.deviceCount = 0;
        System.out.println("[Constructor] AudioMixer created: " + mixerModel);
    }

    public void connectDevice(String deviceName) {
        if (deviceCount < connectedDevices.length) {
            connectedDevices[deviceCount] = deviceName;
            deviceCount++;
            System.out.println("Connected: " + deviceName);
        } else {
            System.out.println("All channels occupied!");
        }
    }

    public void displayMixerStatus() {
        System.out.println("\n=== " + mixerModel + " STATUS ===");
        System.out.println("Channels: " + numberOfChannels);
        System.out.println("Bluetooth: " + (hasBluetoothConnectivity ? "Enabled" : "Disabled"));
        System.out.println("Max Volume: " + maxVolumeDecibels + " dB");
        System.out.println("Connected Devices: " + deviceCount + "/" + numberOfChannels);
        for (int i = 0; i < deviceCount; i++) {
            System.out.println(" Channel " + (i + 1) + ": " + connectedDevices[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== MUSIC STUDIO SETUP ===");
        // Create mixer using no-argument constructor
        AudioMixer mixer1 = new AudioMixer();
        // Create mixer using two-parameter constructor
        AudioMixer mixer2 = new AudioMixer("ProMix-12", 12);
        // Create mixer using three-parameter constructor
        AudioMixer mixer3 = new AudioMixer("LiveMix-16", 16, true);
        // Create mixer using full constructor
        AudioMixer mixer4 = new AudioMixer("UltraMix-4", 4, true, 130.0);

        // Connect different devices to each mixer
        mixer1.connectDevice("Keyboard");
        mixer1.connectDevice("Microphone");
        mixer2.connectDevice("Guitar");
        mixer2.connectDevice("Drums");
        mixer2.connectDevice("Bass");
        mixer3.connectDevice("Laptop");
        mixer3.connectDevice("Synth");
        mixer4.connectDevice("DJ Controller");

        // Display status of all mixers
        mixer1.displayMixerStatus();
        mixer2.displayMixerStatus();
        mixer3.displayMixerStatus();
        mixer4.displayMixerStatus();

        // Comment on constructor chaining execution order
        System.out.println("\n[Info] Constructor chaining starts from most specific to main: No-arg -> 2-param -> 3-param -> main (all params).");
    }
}
