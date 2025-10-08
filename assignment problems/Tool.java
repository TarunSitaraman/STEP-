public class Tool {
    private String privateName = "Private Tool";
    protected int protectedWeight = 500;
    public String publicType = "Hand Tool";

    // Getter for private field
    public String getPrivateName() {
        return privateName;
    }
}

class Hammer extends Tool {
    void testAccess() {
        // System.out.println(privateName); // Not accessible - causes compilation error
        System.out.println(getPrivateName()); // Accessible via getter

        System.out.println(protectedWeight); // Directly accessible
        System.out.println(publicType);      // Directly accessible
    }
}

class Test {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.testAccess();
    }
}
