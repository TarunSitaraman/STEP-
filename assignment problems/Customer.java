import java.time.LocalDateTime;
import java.util.*;

// Immutable Product with factory methods
final class Product {
    private final String id, name, category, manufacturer;
    private final double price, weight;
    private final String[] features;
    private final Map<String, String> specs;

    private Product(String id, String name, String category, String manufacturer, double price, double weight, String[] features, Map<String,String> specs) {
        this.id=id; this.name=name; this.category=category; this.manufacturer=manufacturer;
        this.price=price; this.weight=weight; this.features=features==null?new String[0]:features.clone();
        this.specs=Collections.unmodifiableMap(specs==null?Map.of():new HashMap<>(specs));
    }
    public static Product createElectronics(String i, String n, String m, double p, double w, String[] f, Map<String,String> s)
        { return new Product(i, n, "Electronics", m, p, w, f, s); }
    public static Product createClothing(String i, String n, String m, double p, double w, String[] f, Map<String,String> s)
        { return new Product(i, n, "Clothing", m, p, w, f, s); }
    public static Product createBooks(String i, String n, String m, double p, double w, String[] f, Map<String,String> s)
        { return new Product(i, n, "Books", m, p, w, f, s); }
    public String getName() { return name;}
    public Map<String, String> getSpecs() { return new HashMap<>(specs);}
    public final double calculateTax(String region) {
        return price * ("IN".equals(region) ? 0.18 : "US".equals(region) ? 0.07 : 0.1);
    }
}

// Customer with privacy levels
public class Customer {
    private final String id, email, created;
    private String name, phone, language;
    public Customer(String id, String email, String created) {
        this.id=id; this.email=email; this.created=created;
    }
    String getCreditRating() { return "Good"; } // package-private
    public String getPublicProfile() { return name+" ("+language+")"; }
    public void setName(String n) { this.name=n; }
    public void setPhone(String p) { this.phone=p; }
    public void setLanguage(String l) { this.language=l; }
}

// ShoppingCart access control
class ShoppingCart {
    private final String cartId, customerId;
    private final List<Product> items = new ArrayList<>();
    ShoppingCart(String cartId, String customerId) { this.cartId=cartId; this.customerId=customerId;}
    public boolean addItem(Object prod, int qty) {
        if (!(prod instanceof Product)||qty<1) return false;
        for(int i=0;i<qty;i++)items.add((Product)prod); return true;
    }
    String getCartSummary() { return "Items: "+items.size();}
}

// Order with chaining
class Order {
    private final String id; private final LocalDateTime time;
    public Order() { this(UUID.randomUUID().toString(), LocalDateTime.now()); }
    public Order(String id, LocalDateTime time) { this.id=id; this.time=time; }
}

// Processing classes
class PaymentProcessor { private final String id, key; PaymentProcessor(String i,String k){id=i;key=k;} }
class ShippingCalculator { private final Map<String,Double> rates; ShippingCalculator(Map<String,Double> r){rates=r;} }

// Final system class
final class ECommerceSystem {
    private static final Map<String,Product> catalog=new HashMap<>();
    public static boolean processOrder(Object o,Object c) { return o instanceof Order && c instanceof Customer; }
    public static void addProduct(Product p){catalog.put(p.getName(),p);}
    public static Product getProduct(String name){return catalog.get(name);}
}
