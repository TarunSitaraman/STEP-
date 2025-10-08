public class Light {
    Light() {
        this("Default Light");
        System.out.println("Light(): No-argument constructor");
    }
    Light(String name) {
        System.out.println("Light(String): " + name);
    }
}

class LED extends Light {
    LED() {
        this("Default LED", 1);
        System.out.println("LED(): No-argument constructor");
    }
    LED(String name) {
        super(name);
        System.out.println("LED(String): " + name);
    }
    LED(String name, int intensity) {
        super(name);
        System.out.println("LED(String, int): " + name + ", Intensity: " + intensity);
    }
}

class Test {
    public static void main(String[] args) {
        new LED();
        System.out.println("---");
        new LED("White");
        System.out.println("---");
        new Light();
    }
}
