class ContactInfo implements Cloneable {
    private String email;
    private String phone;
    
    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    @Override
    public String toString() {
        return "ContactInfo[email=" + email + ", phone=" + phone + "]";
    }
}

class Student implements Cloneable {
    private String id;
    private String name;
    private ContactInfo contact;
    
    public Student(String id, String name, ContactInfo contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
    
    public ContactInfo getContact() {
        return contact;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
    public Student deepClone() throws CloneNotSupportedException {
        Student cloned = (Student) super.clone();
        cloned.contact = (ContactInfo) contact.clone();
        return cloned;
    }
    
    @Override
    public String toString() {
        return "Student[id=" + id + ", name=" + name + ", contact=" + contact + "]";
    }
}

public class Registration {
    public static void main(String[] args) throws CloneNotSupportedException {
        ContactInfo contact = new ContactInfo("john@email.com", "1234567890");
        Student original = new Student("S001", "John Doe", contact);
        
        System.out.println("=== Original Student ===");
        System.out.println(original);
        
        System.out.println("\n=== SHALLOW COPY TEST ===");
        Student shallowCopy = (Student) original.clone();
        System.out.println("Shallow Copy: " + shallowCopy);
        
        System.out.println("\nModifying shallow copy's contact...");
        shallowCopy.getContact().setEmail("modified@email.com");
        shallowCopy.getContact().setPhone("9999999999");
        
        System.out.println("Original after shallow copy modification: " + original);
        System.out.println("Shallow Copy after modification: " + shallowCopy);
        System.out.println("Note: Both share the same ContactInfo object!");
        
        System.out.println("\n=== DEEP COPY TEST ===");
        ContactInfo contact2 = new ContactInfo("jane@email.com", "5555555555");
        Student original2 = new Student("S002", "Jane Smith", contact2);
        Student deepCopy = original2.deepClone();
        
        System.out.println("Original2: " + original2);
        System.out.println("Deep Copy: " + deepCopy);
        
        System.out.println("\nModifying deep copy's contact...");
        deepCopy.getContact().setEmail("deepmodified@email.com");
        deepCopy.getContact().setPhone("7777777777");
        
        System.out.println("Original2 after deep copy modification: " + original2);
        System.out.println("Deep Copy after modification: " + deepCopy);
        System.out.println("Note: Each has its own independent ContactInfo object!");
    }
}
