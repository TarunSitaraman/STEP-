public class Fruit {
    protected String color;
    protected String taste;
    
    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    protected String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }
}

class Main {
    public static void main(String[] args) {
        Apple apple = new Apple("Red", "Sweet", "Fuji");
        System.out.println("Apple color: " + apple.color);
        System.out.println("Apple taste: " + apple.taste);
        System.out.println("Apple variety: " + apple.variety);
    }
}
