import java.util.*;

class KingdomConfig {
    private final String kingdomName;
    private final int foundingYear;
    private final String[] allowedTypes;
    private final Map<String, Integer> resourceLimits;

    private KingdomConfig(String name, int year, String[] types, Map<String, Integer> limits) {
        kingdomName = name;
        foundingYear = year;
        allowedTypes = Arrays.copyOf(types, types.length);
        resourceLimits = new HashMap<>(limits);
    }
    public static KingdomConfig createDefaultKingdom() {
        return new KingdomConfig("DefaultLand", 1200, new String[]{"WizardTower","Castle","Library","Lair"}, Map.of("Gold",1000,"Mana",500));
    }
    public static KingdomConfig createFromTemplate(String type) {
        if ("castle".equalsIgnoreCase(type))
            return new KingdomConfig("CastleRealm", 1555, new String[]{"EnchantedCastle"}, Map.of("Defense",999));
        return createDefaultKingdom();
    }
    public String getKingdomName() { return kingdomName; }
    public int getFoundingYear() { return foundingYear; }
    public String[] getAllowedTypes() { return Arrays.copyOf(allowedTypes, allowedTypes.length); }
    public Map<String,Integer> getResourceLimits() { return new HashMap<>(resourceLimits); }
}

public class MagicalStructure {
    private final String structureId;
    private final long constructionTimestamp;
    private final String structureName, location;
    private int magicPower;
    private boolean isActive;
    private String currentMaintainer;
    static final int MIN_MAGIC_POWER = 0, MAX_MAGIC_POWER = 1000;
    public static final String MAGIC_SYSTEM_VERSION = "3.0";

    public MagicalStructure(String name, String location) {
        this(name, location, 100, true, "Unknown");
    }
    public MagicalStructure(String name, String location, int power) {
        this(name, location, power, true, "Unknown");
    }
    public MagicalStructure(String name, String location, int power, boolean active, String maintainer) {
        structureId = UUID.randomUUID().toString();
        constructionTimestamp = System.currentTimeMillis();
        structureName = name;
        this.location = location;
        magicPower = Math.max(MIN_MAGIC_POWER, Math.min(MAX_MAGIC_POWER, power));
        isActive = active;
        currentMaintainer = maintainer;
    }
    public int getMagicPower() { return magicPower; }
    public void setMagicPower(int p) { magicPower = Math.max(MIN_MAGIC_POWER, Math.min(MAX_MAGIC_POWER, p)); }
    public boolean isActive() { return isActive; }
    public void setActive(boolean a) { isActive = a; }
    public String getCurrentMaintainer() { return currentMaintainer; }
    public void setCurrentMaintainer(String m) { currentMaintainer = m; }
    public String getStructureName() { return structureName; }
    public String getLocation() { return location; }
    public String toString() { return structureName + " at " + location + " Power: " + magicPower; }
}

class WizardTower {
    private final int maxSpellCapacity;
    private List<String> knownSpells;
    private String currentWizard;
    private final MagicalStructure structure;
    public WizardTower(String name) {
        this.maxSpellCapacity = 12;
        this.knownSpells = new ArrayList<>();
        this.structure = new MagicalStructure(name, "Hilltop");
        this.currentWizard = "";
    }
    public WizardTower(String name, List<String> spells, String wizard) {
        this.maxSpellCapacity = 24;
        this.knownSpells = new ArrayList<>(spells);
        this.structure = new MagicalStructure(name, "Mountain");
        this.currentWizard = wizard;
    }
    public MagicalStructure getStructure() { return structure; }
}

class EnchantedCastle {
    private final String castleType;
    private int defenseRating;
    private boolean hasDrawbridge;
    private final MagicalStructure structure;
    public EnchantedCastle(String name, String type) {
        this.castleType = type;
        this.defenseRating = 600;
        this.hasDrawbridge = true;
        this.structure = new MagicalStructure(name, "Valley");
    }
    public MagicalStructure getStructure() { return structure; }
}

class MysticLibrary {
    private final Map<String, String> bookCollection;
    private int knowledgeLevel;
    private final MagicalStructure structure;
    public MysticLibrary(String name) {
        this.bookCollection = new HashMap<>();
        this.knowledgeLevel = 80;
        this.structure = new MagicalStructure(name, "Town");
    }
    public MagicalStructure getStructure() { return structure; }
}

class DragonLair {
    private final String dragonType;
    private final long treasureValue;
    private final int territorialRadius;
    private final MagicalStructure structure;
    public DragonLair(String name, String type) {
        this.dragonType = type;
        this.treasureValue = 999999;
        this.territorialRadius = 30;
        this.structure = new MagicalStructure(name, "Cave");
    }
    public MagicalStructure getStructure() { return structure; }
}

class KingdomManager {
    private final List<Object> structures;
    private final KingdomConfig config;
    public KingdomManager(KingdomConfig c) {
        structures = new ArrayList<>();
        config = c;
    }
    public static boolean canStructuresInteract(Object s1, Object s2) {
        return s1 != null && s2 != null && !s1.equals(s2);
    }
    public static String performMagicBattle(Object attacker, Object defender) {
        int ap = attacker instanceof MagicalStructure ? ((MagicalStructure)attacker).getMagicPower() : 0;
        int dp = defender instanceof MagicalStructure ? ((MagicalStructure)defender).getMagicPower() : 0;
        return ap > dp ? "Attacker wins!" : "Defender wins!";
    }
    public static int calculateKingdomPower(Object[] structures) {
        int sum = 0;
        for(Object o: structures)
            if(o instanceof MagicalStructure) sum += ((MagicalStructure)o).getMagicPower();
        return sum;
    }
    private String determineStructureCategory(Object structure) {
        if (structure instanceof WizardTower) return "Tower";
        if (structure instanceof EnchantedCastle) return "Castle";
        if (structure instanceof MysticLibrary) return "Library";
        if (structure instanceof DragonLair) return "Lair";
        return "Unknown";
    }
}
