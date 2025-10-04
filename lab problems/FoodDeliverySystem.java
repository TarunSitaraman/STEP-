public class FoodDeliverySystem {

    double calculateDeliveryCharge(double distanceKm) {
        double charge = distanceKm * 12;
        System.out.println("Basic Delivery: Distance = " + distanceKm + " km, Charge = ₹" + charge);
        return charge;
    }

    double calculateDeliveryCharge(double distanceKm, double priorityFee) {
        double charge = distanceKm * 12 + priorityFee;
        System.out.println("Premium Delivery: Distance = " + distanceKm +
            " km, Priority Fee = ₹" + priorityFee + ", Total Charge = ₹" + charge);
        return charge;
    }

    double calculateDeliveryCharge(double distanceKm, int numOrders) {
        double charge = (distanceKm * 12) * Math.max(0.6, 1.0 - numOrders * 0.07);
        System.out.println("Group Delivery: Distance = " + distanceKm +
            " km, Orders = " + numOrders + ", Discounted Charge = ₹" + charge);
        return charge;
    }

    double calculateDeliveryCharge(double distanceKm, double discountPct, double freeOverAmount, double orderAmount) {
        double charge = distanceKm * 12;
        charge -= charge * (discountPct / 100);
        if (orderAmount >= freeOverAmount) {
            charge = 0;
            System.out.println("Festival Special: Order ≥ ₹" + freeOverAmount +
            " -- Delivery is FREE! (" + distanceKm + " km, " + discountPct + "% discount applied)");
        } else {
            System.out.println("Festival Special: Distance = " + distanceKm +
            " km, Discount = " + discountPct + "%, Charge = ₹" + charge);
        }
        return charge;
    }

    public static void main(String[] args) {
        FoodDeliverySystem system = new FoodDeliverySystem();
        system.calculateDeliveryCharge(8); // Basic
        system.calculateDeliveryCharge(12, 75); // Premium
        system.calculateDeliveryCharge(5, 4); // Group
        system.calculateDeliveryCharge(10, 20, 400, 350); // Festival, not free
        system.calculateDeliveryCharge(6, 15, 500, 600); // Festival, free
    }
}
