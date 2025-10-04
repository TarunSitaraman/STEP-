abstract class Attraction {
    String name;
    Attraction(String name) {
        this.name = name;
    }
    void visitorEntry(String visitor) {
        System.out.println(visitor + " entered the attraction: " + name);
    }
    abstract void operate();
    double processTicket(double basePrice) { return basePrice; }
    double processTicket(double basePrice, boolean isChild) {
        return isChild ? basePrice * 0.7 : basePrice;
    }
}

class RollerCoaster extends Attraction {
    int minHeightCm;
    String thrillLevel;
    RollerCoaster(String name, int minHeightCm, String thrillLevel) {
        super(name);
        this.minHeightCm = minHeightCm;
        this.thrillLevel = thrillLevel;
    }
    @Override
    void operate() {
        System.out.println("RollerCoaster " + name + ": Height requirement " + minHeightCm +
            "cm, Thrill: " + thrillLevel + ", Safety check passed.");
    }
    double processTicket(double basePrice, boolean isChild, boolean fastPass) {
        double price = super.processTicket(basePrice, isChild);
        return fastPass ? price + 250 : price;
    }
}

class WaterRide extends Attraction {
    boolean requiresSwim;
    boolean weatherGood;
    boolean equipmentRentalAvailable;
    WaterRide(String name, boolean requiresSwim, boolean weatherGood, boolean rental) {
        super(name);
        this.requiresSwim = requiresSwim;
        this.weatherGood = weatherGood;
        this.equipmentRentalAvailable = rental;
    }
    @Override
    void operate() {
        System.out.println("WaterRide " + name + ": Weather good: " + weatherGood +
            ", Swim ability required: " + requiresSwim + ", Rentals: " + equipmentRentalAvailable);
    }
    double processTicket(double basePrice, boolean needsRental) {
        return needsRental && equipmentRentalAvailable ? basePrice + 100 : basePrice;
    }
}

class Show extends Attraction {
    int capacity;
    String showtime;
    String contentRating;
    Show(String name, int capacity, String time, String rating) {
        super(name);
        this.capacity = capacity;
        this.showtime = time;
        this.contentRating = rating;
    }
    @Override
    void operate() {
        System.out.println("Show " + name + ": Starts at " + showtime +
            " | Capacity: " + capacity + ", Rating: " + contentRating);
    }
    double processTicket(double basePrice, boolean isMember) {
        return isMember ? basePrice * 0.5 : basePrice;
    }
}

class Game extends Attraction {
    String skillLevel;
    String prizeTier;
    boolean groupPlayAvailable;
    Game(String name, String skill, String prize, boolean group) {
        super(name);
        this.skillLevel = skill;
        this.prizeTier = prize;
        this.groupPlayAvailable = group;
    }
    @Override
    void operate() {
        System.out.println("Game " + name + ": " + skillLevel + " skill, Prizes: " +
            prizeTier + ", Group: " + groupPlayAvailable);
    }
    double processTicket(double basePrice, int groupSize) {
        return groupPlayAvailable && groupSize >= 4 ? (basePrice * 0.75) * groupSize : basePrice * groupSize;
    }
}

public class ThemeParkSystem {
    public static void manageAttractionMaintenance(Attraction[] allAttractions) {
        for (Attraction a : allAttractions) {
            System.out.println("Maintenance scheduled for: " + a.name);
            if (a instanceof RollerCoaster) {
                System.out.println("Performing safety check for coaster.");
            } else if (a instanceof WaterRide) {
                System.out.println("Draining and cleaning water systems.");
            } else if (a instanceof Show) {
                System.out.println("Checking sound, lights, and seating.");
            } else if (a instanceof Game) {
                System.out.println("Restocking game prizes.");
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        Attraction[] park = {
            new RollerCoaster("ThunderBolt", 140, "Extreme"),
            new WaterRide("AquaSplash", true, true, true),
            new Show("Big Top Circus", 300, "5:30 PM", "G"),
            new Game("Ring Toss", "Intermediate", "Gold/Silver", true)
        };

        for (Attraction a : park) {
            a.visitorEntry("Sam");
            a.operate();
            double price = a.processTicket(500); // Overloaded handled as per object
            System.out.println("Standard Ticket: ₹" + price);

            if (a instanceof RollerCoaster) {
                price = ((RollerCoaster)a).processTicket(500, false, true);
                System.out.println("Coaster, adult, FastPass: ₹" + price);
            } else if (a instanceof WaterRide) {
                price = ((WaterRide)a).processTicket(500, true);
                System.out.println("WaterRide with rental: ₹" + price);
            } else if (a instanceof Show) {
                price = ((Show)a).processTicket(500, true);
                System.out.println("Member ticket: ₹" + price);
            } else if (a instanceof Game) {
                price = ((Game)a).processTicket(120, 5);
                System.out.println("Group ticket (5 players): ₹" + price);
            }
            System.out.println("---");
        }

        manageAttractionMaintenance(park);
    }
}
