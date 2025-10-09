// Abstract class Shape with abstract methods
abstract class Shape {
    // Abstract methods for calculation
    abstract double area();
    abstract double perimeter();

    // Concrete method to display info
    public void displayInfo() {
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}

// Subclass for Circle
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Subclass for Rectangle
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

// Test class to demonstrate functionality
public class TestShapes {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        Shape r = new Rectangle(4, 6);

        System.out.println("Circle:");
        c.displayInfo();

        System.out.println("---");

        System.out.println("Rectangle:");
        r.displayInfo();
    }
}
