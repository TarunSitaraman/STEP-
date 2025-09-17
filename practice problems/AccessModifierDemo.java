public class AccessModifierDemo {
    // Four fields with different access modifiers
    private int privateField;
    String defaultField;           // default (package-private) access
    protected double protectedField;
    public boolean publicField;

    // Constructor to initialize all fields
    public AccessModifierDemo(int priv, String def, double prot, boolean pub) {
        privateField = priv;
        defaultField = def;
        protectedField = prot;
        publicField = pub;
    }

    // Four methods with different access modifiers
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {  // package-private
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Public method to test internal access
    public void testInternalAccess() {
        System.out.println("Accessing fields internally:");
        System.out.println("privateField = " + privateField);
        System.out.println("defaultField = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField = " + publicField);

        System.out.println("Calling methods internally:");
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
        // All accessible within the same class
    }

    public static void main(String[] args) {
        AccessModifierDemo demo = new AccessModifierDemo(10, "default", 3.14, true);

        // Accessible in same class:
        System.out.println("Access in main:");

        // System.out.println(demo.privateField); // OK (main method is inside class)
        // System.out.println(demo.defaultField); // OK
        // System.out.println(demo.protectedField); // OK
        // System.out.println(demo.publicField); // OK

        // demo.privateMethod(); // OK
        // demo.defaultMethod(); // OK
        // demo.protectedMethod(); // OK
        // demo.publicMethod(); // OK

        demo.testInternalAccess(); // Shows all internal accesses

        // NOTE: The commented out lines above will work in main method, since it's inside class
    }
}

// Second class in SAME package for testing
class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo demo = new AccessModifierDemo(20, "same", 6.28, false);

        // System.out.println(demo.privateField);     // ERROR: private (not accessible)
        System.out.println(demo.defaultField);        // OK: default/package-private
        System.out.println(demo.protectedField);      // OK: protected
        System.out.println(demo.publicField);         // OK: public

        // demo.privateMethod();    // ERROR: private (not accessible)
        demo.defaultMethod();      // OK: default/package-private
        demo.protectedMethod();    // OK: protected
        demo.publicMethod();       // OK: public
    }
}
