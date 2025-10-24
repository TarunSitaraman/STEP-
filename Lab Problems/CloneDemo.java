class Address implements Cloneable {
    String city;
    public Address(String city) {
        this.city = city;
    }
    // Copy constructor for deep copy
    public Address(Address other) {
        this.city = other.city;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Shallow copy
    }
    @Override
    public String toString() {
        return "Address[city=" + city + "]";
    }
}

class Person implements Cloneable {
    String name;
    Address address;
    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    // Shallow copy: just call super.clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    // Deep copy: clone Person and also clone Address
    public Person deepClone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address); // Use copy constructor
        return cloned;
    }
    @Override
    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}

public class CloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address addr = new Address("Chennai");
        Person original = new Person("Ravi", addr);

        // Shallow clone
        Person shallowClone = (Person) original.clone();
        // Deep clone
        Person deepClone = original.deepClone();

        System.out.println("--- Before modification ---");
        System.out.println("Original:      " + original);
        System.out.println("Shallow Clone: " + shallowClone);
        System.out.println("Deep Clone:    " + deepClone);

        // Change address in shallow clone
        shallowClone.address.city = "Mumbai";
        // Change address in deep clone
        deepClone.address.city = "Delhi";

        System.out.println("\n--- After modification ---");
        System.out.println("Original:      " + original);
        System.out.println("Shallow Clone: " + shallowClone);
        System.out.println("Deep Clone:    " + deepClone);
    }
}
