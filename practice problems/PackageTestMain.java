// File: com/company/main/PackageTestMain.java
package com.company.main;
// TODO: Import the AccessModifierDemo class from com.company.security
public class PackageTestMain {
    public static void main(String[] args) {
        // TODO: Create AccessModifierDemo object
        AccessModifierDemo demo = new AccessModifierDemo(10, "test", 5.5, true);
        // TODO: Attempt to access each field and method
        System.out.println(demo.privateField);   
        System.out.println(demo.defaultField);   
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);
        // TODO: Document which access modifiers work across packages
        demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
        // TODO: Explain why certain accesses fail
    }
}
// TODO: Create a subclass in different package:
// File: com/company/extended/ExtendedDemo.
package com.company.extended;

// TODO: Import AccessModifierDemo
// TODO: Create class ExtendedDemo that extends AccessModifierDemo
class ExtendedDemo extends AccessModifierDemo {
    // TODO: Create constructor that calls super constructor
public void testInheritedAccess() {
// TODO: Try accessing inherited fields with different modifiers
    System.out.println(this.privateField);   
    System.out.println(this.defaultField);   
    System.out.println(this.protectedField);
    System.out.println(this.publicField);
// TODO: Try calling inherited methods with different modifiers
    this.privateMethod();
    this.defaultMethod();
    this.protectedMethod();
    this.publicMethod();
// TODO: Document which protected members are accessible
// TODO: Show that private members are NOT inherited
}

    // TODO: Override protected method from parent class
    public static void main(String[] args) {
        // TODO: Test inheritance access rules
        ExtendedDemo extDemo = new ExtendedDemo(20, "extended", 9.81, false);
        // TODO: Create both parent and child objects
        // TODO: Compare what each can access
    }
}