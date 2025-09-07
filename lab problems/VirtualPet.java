public class VirtualPet {
    // Fields
    public final String petId;
    public String petName, species;
    public int age, happiness, health;
    public static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder", "Ghost"};
    public static int totalPetsCreated = 0;
    private int stageIdx;
    private boolean isGhost;

    // Simple petId generator based on counter
    public static String generatePetId() {
        return "PET" + (++totalPetsCreated);
    }

    // Default constructor: mysterious egg
    public VirtualPet() {
        this("Mystery", "Random", 0, 50, 50, 0);
    }

    // Name-only constructor: baby stage
    public VirtualPet(String name) {
        this(name, "Random", 1, 60, 60, 1);
    }

    // Name and species: child stage
    public VirtualPet(String name, String species) {
        this(name, species, 2, 70, 70, 2);
    }

    // Full constructor: all fields
    public VirtualPet(String name, String species, int age, int happiness, int health, int stageIdx) {
        this.petId = generatePetId();
        this.petName = name;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stageIdx = stageIdx;
        this.isGhost = false;
    }

    // Evolve logic
    public void evolvePet() {
        if (isGhost) return;
        if (health <= 0) {
            stageIdx = 6; // Ghost
            isGhost = true;
            species = "Ghost";
            System.out.println(petName + " became a Ghost!");
            return;
        }
        if (age < 2) stageIdx = 0;
        else if (age < 4) stageIdx = 1;
        else if (age < 7) stageIdx = 2;
        else if (age < 10) stageIdx = 3;
        else if (age < 14) stageIdx = 4;
        else stageIdx = 5;
    }

    public void feedPet() { if (!isGhost) health += 10; }
    public void playWithPet() { if (!isGhost) happiness += 10; }
    public void healPet() { if (!isGhost) health += 5; }
    public void simulateDay() {
        if (!isGhost) {
            age++; evolution();
            happiness -= 5; health -= 5;
            if (health <= 0) evolvePet();
        }
    }
    private void evolution() { evolvePet(); }

    public String getPetStatus() {
        return EVOLUTION_STAGES[stageIdx] + (isGhost ? " (Ghost)" : "");
    }

    public void displayInfo() {
        System.out.println("ID: " + petId + " | Name: " + petName + " | Species: " + species +
                " | Age: " + age + " | Stage: " + getPetStatus() + " | Happy: " +
                happiness + " | Health: " + health);
    }

    public static void main(String[] args) {
        // Create pets using different constructors
        VirtualPet a = new VirtualPet();
        VirtualPet b = new VirtualPet("Berry");
        VirtualPet c = new VirtualPet("Drako", "Dragon");
        VirtualPet d = new VirtualPet("Tiny", "Turtle", 11, 80, 90, 4);

        VirtualPet[] pets = {a, b, c, d};

        // Simulate several days
        for (int day = 1; day <= 3; day++) {
            System.out.println("\nDay " + day);
            for (VirtualPet p : pets) {
                p.simulateDay();
                p.feedPet();
                p.playWithPet();
                p.healPet();
                p.displayInfo();
            }
        }

        c.health = 0; c.evolvePet(); // Make Drako a ghost

        System.out.println("\nTotal pets created: " + totalPetsCreated);
        for (VirtualPet p : pets) p.displayInfo();
    }
}
