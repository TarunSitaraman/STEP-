// Interface for common behavior
interface Edible {
    void nutrientsInfo();
}

// Abstract parent class
abstract class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    // Abstract method
    public abstract void showDetails();
}

// Concrete child class, extends Fruit and implements Edible
class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in fiber, Vitamin C, antioxidants.");
    }
}

// Test class
public class TestFruit {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showDetails();
        a.nutrientsInfo();
    }
}
