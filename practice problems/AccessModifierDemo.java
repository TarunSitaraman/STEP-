package som.company.security;

public class AccessModifierDemo {
    // Fields with different access modifiers
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    // Constructor to initialize all fields
    public AccessModifierDemo(int priv, String def, double prot, boolean pub) {
        privateField = priv;
        defaultField = def;
        protectedField = prot;
        publicField = pub;
    }

    // Methods with different access modifiers
    private void privateMethod() {
        System.out.println("Private method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Demonstrate internal access to all fields and methods
    public void testInternalAccess() {
        // All fields accessible within the class
        System.out.println("privateField   = " + privateField);
        System.out.println("defaultField   = " + defaultField);
        System.out.println("protectedField = " + protectedField);
        System.out.println("publicField    = " + publicField);

        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "default", 3.14, true);

        System.out.println(obj.privateField);
        System.out.println(obj.defaultField);
        System.out.println(obj.protectedField);
        System.out.println(obj.publicField);

        obj.privateMethod();
        obj.defaultMethod();
        obj.protectedMethod();
        obj.publicMethod();

        obj.testInternalAccess();
    }

    class SamePackageTest {
        public static void testAccess() {
            AccessModifierDemo obj = new AccessModifierDemo(5, "test", 2.71, false);

            System.out.println(obj.privateField);
            System.out.println(obj.defaultField);
            System.out.println(obj.protectedField);
            System.out.println(obj.publicField);

            obj.privateMethod();
            obj.defaultMethod();
            obj.protectedMethod();
            obj.publicMethod();
        }
    }
}