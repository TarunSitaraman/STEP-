import java.util.Arrays;

final class PetSpecies {
    private final String name;
    private final String[] evolution;
    private final int lifespan;
    private final String habitat;

    public PetSpecies(String name, String[] evolution, int lifespan, String habitat) {
        this.name = name;
        this.evolution = Arrays.copyOf(evolution, evolution.length);
        this.lifespan = lifespan;
        this.habitat = habitat;
    }
    public String getName() { return name; }
    public String[] getEvolution() { return Arrays.copyOf(evolution, evolution.length); }
    public int getLifespan() { return lifespan; }
    public String getHabitat() { return habitat; }
}

public class VirtualPet {
    private final String id;
    private final PetSpecies species;
    private final long birthTime;
    private String name;
    private int age, happiness, health;
    protected static final String[] DEFAULT_EVOLUTION = {"Baby", "Adult"};
    static final int MAX_HAPPINESS = 100, MAX_HEALTH = 100;
    public static final String VERSION = "2.0";

    public VirtualPet() { this("Pet" + System.nanoTime(), new PetSpecies("Default", DEFAULT_EVOLUTION, 15, "Home"), "Buddy", System.currentTimeMillis(), 0, 60, 60); }
    public VirtualPet(String name) { this("Pet" + System.nanoTime(), new PetSpecies("Default", DEFAULT_EVOLUTION, 15, "Home"), name, System.currentTimeMillis(), 0, 60, 60); }
    public VirtualPet(String name, PetSpecies species) { this("Pet" + System.nanoTime(), species, name, System.currentTimeMillis(), 0, 60, 60); }
    public VirtualPet(String id, PetSpecies species, String name, long birthTime, int age, int happiness, int health) {
        this.id = id; this.species = species; this.name = name; this.birthTime = birthTime;
        this.age = age; setHappiness(happiness); setHealth(health);
    }
    public String getId() { return id; }
    public PetSpecies getSpecies() { return species; }
    public String getName() { return name; }
    public void setName(String name) { if (name != null) this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { if (age >= 0) this.age = age; }
    public int getHappiness() { return happiness; }
    public void setHappiness(int h) { happiness = Math.max(0, Math.min(MAX_HAPPINESS, h)); }
    public int getHealth() { return health; }
    public void setHealth(int h) { health = Math.max(0, Math.min(MAX_HEALTH, h)); }
    public void feedPet() { setHealth(health + 10); }
    public void playWithPet() { setHappiness(happiness + 10); }
    @Override
    public String toString() { return name + " (" + species.getName() + ") Happy: " + happiness + " Health: " + health; }
}

final class DragonPet {
    private final String type;
    private final String weapon;
    private final VirtualPet pet;

    public DragonPet(String type, String weapon, String name) {
        this.type = type;
        this.weapon = weapon;
        this.pet = new VirtualPet(name, new PetSpecies("Dragon", new String[]{"Egg","Young","Ancient"}, 100, "Mountain"));
    }
    public VirtualPet getPet() { return pet; }
}

final class RobotPet {
    private final VirtualPet pet;
    private boolean charging;
    private int battery;

    public RobotPet(String name) {
        charging = false;
        battery = 100;
        pet = new VirtualPet(name, new PetSpecies("Robot", new String[]{"Kit","Juvenile","Android"}, 20, "Lab"));
    }
    public int getBattery() { return battery; }
    public void setBattery(int b) { battery = Math.max(0, Math.min(100, b)); }
    public boolean needsCharging() { return charging; }
    public void setCharging(boolean c) { charging = c; }
    public VirtualPet getPet() { return pet; }
}
