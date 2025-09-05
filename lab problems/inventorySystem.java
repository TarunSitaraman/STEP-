class Supplier {
    String name;
    String contact;
    
    Supplier(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }
}

class Product {
    String id;
    String name;
    int quantity;
    Supplier supplier;
    
    Product(String id, String name, int quantity, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.supplier = supplier;
    }
}

class InventorySystem {
    final int MAX_PRODUCTS = 100;
    final int MAX_SUPPLIERS = 20;
    Product[] products = new Product[MAX_PRODUCTS];
    Supplier[] suppliers = new Supplier[MAX_SUPPLIERS];
    int productCount = 0;
    int supplierCount = 0;

    void addSupplier(String name, String contact) {
        if (supplierCount < MAX_SUPPLIERS) {
            suppliers[supplierCount++] = new Supplier(name, contact);
        }
    }

    void addProduct(String id, String name, int quantity, int supplierIndex) {
        if (productCount < MAX_PRODUCTS && supplierIndex < supplierCount) {
            products[productCount++] = new Product(id, name, quantity, suppliers[supplierIndex]);
        }
    }

    void viewProducts() {
        System.out.println("Product List:");
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].id + " | " + products[i].name + " | Qty: " + products[i].quantity
                               + " | Supplier: " + products[i].supplier.name);
        }
    }

    void removeProduct(String id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].id.equals(id)) {
                products[i] = products[productCount - 1]; // Replace with last
                productCount--;
                break;
            }
        }
    }
    
    // Optionally add more features: search product, low stock alert, etc.
}

class Main {
    public static void main(String[] args) {
        InventorySystem inv = new InventorySystem();
        inv.addSupplier("Global Corp", "1234567890");
        inv.addSupplier("East Traders", "9876543210");
        
        inv.addProduct("P001", "Mouse", 50, 0);
        inv.addProduct("P002", "Keyboard", 20, 1);
        inv.viewProducts();
        
        inv.removeProduct("P002");
        inv.viewProducts();
    }
}
