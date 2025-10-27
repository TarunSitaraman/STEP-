import java.util.*;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }

    public String getName() {
        return name;
    }
}

class Order {
    private String orderId;
    private List<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added product '" + product.getName() + "' to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("Order " + orderId + " contains:");
        for (Product product : products) {
            product.showDetails();
        }
    }
}

class Customer {
    private String name;
    private String email;
    private List<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order " + order.orderId);
    }

    public void showCustomerOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}

public class ShoppingDemo {
    public static void main(String[] args) {
        Customer customer = new Customer("Amit", "amit@gmail.com");

        Product p1 = new Product("Laptop", 65000);
        Product p2 = new Product("Mobile", 18000);
        Product p3 = new Product("Mouse", 750);

        Order o1 = new Order("ORD1001");
        Order o2 = new Order("ORD1002");
        o1.addProduct(p1);
        o1.addProduct(p3);
        o2.addProduct(p2);

        customer.placeOrder(o1);
        customer.placeOrder(o2);

        customer.showCustomerOrders();
    }
}
