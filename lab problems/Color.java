public class Color {
    String name;
    Color(String name) {
        this.name = name;
        System.out.println("Color constructor: name = " + name);
    }
    void displayName() {
        System.out.println("Color: " + name);
    }
}

class PrimaryColor extends Color {
    int intensity;
    PrimaryColor(String name, int intensity) {
        super(name); // calls Color constructor
        this.intensity = intensity;
        System.out.println("PrimaryColor constructor: intensity = " + intensity);
    }
    void displayIntensity() {
        System.out.println("PrimaryColor intensity: " + intensity);
    }
}

class RedColor extends PrimaryColor {
    String shade;
    RedColor(String name, int intensity, String shade) {
        super(name, intensity); // calls PrimaryColor constructor
        this.shade = shade;
        System.out.println("RedColor constructor: shade = " + shade);
    }
    void displayShade() {
        System.out.println("RedColor shade: " + shade);
    }
}

class Main {
    public static void main(String[] args) {
        RedColor rc = new RedColor("Red", 85, "Bright");
        rc.displayName();
        rc.displayIntensity();
        rc.displayShade();
    }
}
