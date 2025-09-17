public class Instrument {
    String name;
    String material;
    
    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
    public void play() {
        System.out.println("Playing " + name);
    }
}

class Piano extends Instrument {
    int keys;
    
    Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }
    public void play() {
        System.out.println("Playing Piano with " + keys + " keys.");
    }
}

class Guitar extends Instrument {
    int strings;
    
    Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }
    public void play() {
        System.out.println("Playing Guitar with " + strings + " strings.");
    }
}

class Drum extends Instrument {
    double diameter;
    
    Drum(String name, String material, double diameter) {
        super(name, material);
        this.diameter = diameter;
    }
    public void play() {
        System.out.println("Playing Drum with diameter " + diameter + " cm.");
    }
}

class Main {
    public static void main(String[] args) {
        Instrument[] band = new Instrument[3];
        band[0] = new Piano("Grand Piano", "Wood", 88);
        band[1] = new Guitar("Acoustic Guitar", "Wood", 6);
        band[2] = new Drum("Bass Drum", "Metal", 50.5);

        for (Instrument inst : band) {
            inst.play(); // Demonstrates polymorphism
        }
    }
}
