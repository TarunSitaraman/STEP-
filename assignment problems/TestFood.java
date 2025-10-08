abstract class Food {
    // Template method defines the algorithm skeleton
    public final void prepare() {
        wash();
        cook();
        serve();
    }
    // Steps to be implemented by subclasses
    protected abstract void wash();
    protected abstract void cook();
    protected abstract void serve();
}

class Pizza extends Food {
    @Override
    protected void wash() {
        System.out.println("Washing vegetables for pizza.");
    }
    @Override
    protected void cook() {
        System.out.println("Baking dough and adding toppings.");
    }
    @Override
    protected void serve() {
        System.out.println("Serving hot pizza slices.");
    }
}

class Soup extends Food {
    @Override
    protected void wash() {
        System.out.println("Rinsing soup ingredients.");
    }
    @Override
    protected void cook() {
        System.out.println("Simmering soup on the stove.");
    }
    @Override
    protected void serve() {
        System.out.println("Pouring soup into bowls.");
    }
}

public class TestFood {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();

        f1.prepare();
        System.out.println("---");
        f2.prepare();
    }
}
