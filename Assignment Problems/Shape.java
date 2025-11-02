// Abstract class representing a generic Shape

abstract class Shape {

    String name;

    Shape(String name) {
        this.name = name;
    }

    // Abstract method
    abstract double area();

    // Concrete method
    public void moveTo(int x, int y) {
        System.out.println(name + " moved to x = " + x + ", y = " + y);
    }
}

class Rectangle extends Shape {

    int width, height;

    Rectangle(int width, int height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    // Implementing the abstract method
    double area() {
        return width * height;
    }
}
