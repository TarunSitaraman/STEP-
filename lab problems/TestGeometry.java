// Interface for extra behavior
interface Drawable {
    void draw();
}

// Abstract class for shared state and core operations
abstract class Shape {
    protected double area;
    protected double perimeter;

    // Abstract methods for calculation logic
    public abstract void calculateArea();
    public abstract void calculatePerimeter();
}

// Concrete class: Circle
class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implement abstract methods
    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    // Implement interface method
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }

    // Convenience method to display results
    public void showDetails() {
        System.out.println("Circle - Area: " + area + ", Perimeter: " + perimeter);
    }
}

// Testing all features
public class TestGeometry {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.calculateArea();
        c.calculatePerimeter();
        c.draw();
        c.showDetails();
    }
}
