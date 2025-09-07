public class FoodOrder {
    String customerName;
    String foodItem;
    int quantity;
    double price;
    static final double FIXED_RATE = 100.0;

    // Default constructor
    public FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    // Constructor with food item
    public FoodOrder(String item) {
        this("Unknown", item, 1, FIXED_RATE);
    }

    // Constructor with food item and quantity
    public FoodOrder(String item, int qty) {
        this("Unknown", item, qty, qty * FIXED_RATE);
    }

    // Full constructor
    public FoodOrder(String name, String item, int qty, double price) {
        this.customerName = name;
        this.foodItem = item;
        this.quantity = qty;
        this.price = price;
    }

    // Method to print bill
    public void printBill() {
        System.out.println("Customer: " + customerName +
            ", Item: " + foodItem +
            ", Quantity: " + quantity +
            ", Total: " + price);
    }

    public static void main(String[] args) {
        FoodOrder o1 = new FoodOrder();
        FoodOrder o2 = new FoodOrder("Burger");
        FoodOrder o3 = new FoodOrder("Pizza", 3);
        FoodOrder o4 = new FoodOrder("Alice", "Pasta", 2, 180.0);

        o1.printBill();
        o2.printBill();
        o3.printBill();
        o4.printBill();
    }
}
