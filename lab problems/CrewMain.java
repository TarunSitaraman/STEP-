class SpaceCrew {
    public final String crewId;
    public final String homeplanet;
    public final String initialRank;
    public String currentRank;
    public int skillLevel;
    public static final String STATION_NAME = "Stellar Odyssey";

    public SpaceCrew(String id, String planet, String rank) {
        this.crewId = id;
        this.homeplanet = planet;
        this.initialRank = rank;
        this.currentRank = rank;
        this.skillLevel = 1;
    }
    public final String getCrewIdentification() {
        return crewId + "@" + homeplanet;
    }
    public final boolean canBePromoted() {
        return skillLevel > 2;
    }
}

class SpaceStationRegistry {
    static int crewCount = 0;
    static void addCrew() { crewCount++; }
    static int getTotalCrew() { return crewCount; }
}

public class CrewMain {
    public static void main(String[] args) {
        SpaceCrew a = new SpaceCrew("C1", "Earth", "CADET");
        SpaceCrew b = new SpaceCrew("C2", "Mars", "OFFICER");
        SpaceStationRegistry.addCrew();
        SpaceStationRegistry.addCrew();
        System.out.println(a.getCrewIdentification());
        System.out.println(b.canBePromoted());
        System.out.println(SpaceStationRegistry.getTotalCrew());
    }
}
