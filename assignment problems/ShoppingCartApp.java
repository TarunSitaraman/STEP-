class Product {
    String id;
    String name;
    double price;
    int quantity;

    Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Cart {
    Product[] items = new Product[20];
    int count = 0;

    void addProduct(Product p, int qty) {
        if (p.quantity >= qty) {
            items[count++] = new Product(p.id, p.name, p.price, qty);
            p.quantity -= qty;
        }
    }

    void removeProduct(String prodId) {
        for (int i = 0; i < count; i++) {
            if (items[i].id.equals(prodId)) {
                items[i] = items[count - 1];
                count--;
                break;
            }
        }
    }

    void viewCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].id + " | " + items[i].name + " | Qty: " + items[i].quantity + " | Price: " + items[i].price);
        }
    }

    double checkout() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += items[i].price * items[i].quantity;
        }
        return total;
    }
}

class Customer {
    String name;
    Cart cart = new Cart();

    Customer(String name) {
        this.name = name;
    }
}

public class ShoppingCartApp {
    public static void main(String[] args) {
        Product[] inventory = {
            new Product("P101", "Laptop", 50000.0, 10),
            new Product("P102", "Mouse", 500.0, 50),
            new Product("P103", "Keyboard", 1200.0, 30)
        };

        Customer customer = new Customer("Meena");

        // Simulate adding items to cart
        customer.cart.addProduct(inventory[21], 2);
        customer.cart.addProduct(inventory[22], 1);

        customer.cart.viewCart();

        customer.cart.removeProduct("P102"); // Remove Mouse
        customer.cart.viewCart();

        double bill = customer.cart.checkout();
        System.out.println("Total Bill: " + bill);
    }
}
