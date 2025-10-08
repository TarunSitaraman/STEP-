class BasicMath {
    // Overloaded methods with different parameters
    public int calculate(int a, int b) {
        System.out.println("Adding two ints in BasicMath");
        return a + b;
    }
    public double calculate(double a, double b) {
        System.out.println("Adding two doubles in BasicMath");
        return a + b;
    }
    public int calculate(int a, int b, int c) {
        System.out.println("Adding three ints in BasicMath");
        return a + b + c;
    }
}

class AdvancedMath extends BasicMath {
    // Inherits all calculate() from BasicMath
    // Add new overloaded methods
    public int calculate(int a) {
        System.out.println("Squaring int in AdvancedMath");
        return a * a;
    }
    public double calculate(double a, double b, double c) {
        System.out.println("Multiplying three doubles in AdvancedMath");
        return a * b * c;
    }
    public int calculate(int a, int b, int c, int d) {
        System.out.println("Adding four ints in AdvancedMath");
        return a + b + c + d;
    }
}

public class TestMath {
    public static void main(String[] args) {
        AdvancedMath math = new AdvancedMath();

        // Inherited from BasicMath
        System.out.println(math.calculate(3, 5));
        System.out.println(math.calculate(2.5, 7.5));
        System.out.println(math.calculate(1, 2, 3));

        // New in AdvancedMath
        System.out.println(math.calculate(4));
        System.out.println(math.calculate(2.0, 3.0, 4.0));
        System.out.println(math.calculate(1, 2, 3, 4));
    }
}
