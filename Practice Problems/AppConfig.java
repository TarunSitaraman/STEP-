public class AppConfig {
    private String appName;
    public static String defaultAppName = "MyApp"; // Example static member

    public AppConfig(String appName) {
        this.appName = appName;
    }

    public static class NetworkConfig {
        private String host;
        private int port;

        public NetworkConfig(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void displayConfig() {
            System.out.println("Network Host: " + host);
            System.out.println("Network Port: " + port);
            System.out.println("App Name (static): " + AppConfig.defaultAppName);
        }
    }
}

class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig netConfig = new AppConfig.NetworkConfig("localhost", 8080);
        netConfig.displayConfig();
    }
}
