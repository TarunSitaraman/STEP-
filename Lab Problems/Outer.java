public class Outer {
    private String message = "Hello from Outer!";

    // Non-static inner class
    class Inner {
        public void display() {
            // Directly access private member of Outer
            System.out.println("Message: " + message);
        }
    }

    public static void main(String[] args) {
        Outer outerObj = new Outer();
        Outer.Inner innerObj = outerObj.new Inner();
        innerObj.display();
    }
}
