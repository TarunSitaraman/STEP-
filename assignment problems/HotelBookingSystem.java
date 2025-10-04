public class HotelBookingSystem {

    double getRoomBasePrice(String roomType) {
        switch (roomType.toLowerCase()) {
            case "single": return 2000;
            case "double": return 3500;
            case "suite":  return 6000;
            default: return 0;
        }
    }

    void calculatePrice(String roomType, int nights) {
        double basePrice = getRoomBasePrice(roomType) * nights;
        System.out.println("Booking Type: Standard");
        System.out.println("Room: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: ₹" + basePrice);
        System.out.println("Total Amount: ₹" + basePrice);
        System.out.println("---");
    }

    void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        double base = getRoomBasePrice(roomType) * nights;
        double adjusted = base * seasonalMultiplier;
        System.out.println("Booking Type: Seasonal");
        System.out.println("Room: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: ₹" + base);
        System.out.println("Seasonal Multiplier: x" + seasonalMultiplier);
        System.out.println("Adjusted Price: ₹" + adjusted);
        System.out.println("Total Amount: ₹" + adjusted);
        System.out.println("---");
    }

    void calculatePrice(String roomType, int nights, double corpDiscount, double mealPackage) {
        double base = getRoomBasePrice(roomType) * nights;
        double meal = mealPackage * nights;
        double subtotal = base + meal;
        double discountAmount = subtotal * corpDiscount;
        double total = subtotal - discountAmount;
        System.out.println("Booking Type: Corporate");
        System.out.println("Room: " + roomType + ", Nights: " + nights);
        System.out.println("Base Price: ₹" + base);
        System.out.println("Meal Package: ₹" + meal + " (₹" + mealPackage + " per night)");
        System.out.println("Subtotal: ₹" + subtotal);
        System.out.println("Corporate Discount: -" + (corpDiscount * 100) + "% (₹" + discountAmount + ")");
        System.out.println("Total Amount: ₹" + total);
        System.out.println("---");
    }

    void calculatePrice(String roomType, int nights, int guests, double decorationFee, double cateringPerGuest) {
        double base = getRoomBasePrice(roomType) * nights;
        double catering = cateringPerGuest * guests;
        double total = base + decorationFee + catering;
        System.out.println("Booking Type: Wedding Package");
        System.out.println("Room: " + roomType + ", Nights: " + nights + ", Guests: " + guests);
        System.out.println("Base Price: ₹" + base);
        System.out.println("Decoration Fee: ₹" + decorationFee);
        System.out.println("Catering: ₹" + catering + " (₹" + cateringPerGuest + " per guest)");
        System.out.println("Total Amount: ₹" + total);
        System.out.println("---");
    }

    public static void main(String[] args) {
        HotelBookingSystem hbs = new HotelBookingSystem();
        hbs.calculatePrice("Double", 2);
        hbs.calculatePrice("Suite", 3, 1.5);
        hbs.calculatePrice("Single", 4, 0.10, 500);
        hbs.calculatePrice("Suite", 2, 100, 10000, 1200);
    }
}
