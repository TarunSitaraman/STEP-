public class MovieTicket {
    String movieName;
    String theatreName;
    int seatNumber;
    double price;

    // Default constructor
    public MovieTicket() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // Constructor with movie name
    public MovieTicket(String name) {
        this(name, "Unknown", 0, 200.0);
    }

    // Constructor with movie name and seat number
    public MovieTicket(String name, int seat) {
        this(name, "PVR", seat, 200.0);
    }

    // Full constructor
    public MovieTicket(String name, String theatre, int seat, double price) {
        this.movieName = name;
        this.theatreName = theatre;
        this.seatNumber = seat;
        this.price = price;
    }

    // Method to print ticket details
    public void printTicket() {
        System.out.println("Movie: " + movieName + ", Theatre: " + theatreName +
                ", Seat: " + seatNumber + ", Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Avatar", 12);
        MovieTicket t4 = new MovieTicket("Joker", "Cineplex", 8, 350.0);

        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
