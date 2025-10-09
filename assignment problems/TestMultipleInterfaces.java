// Printer interface
interface Printer {
    void connect();
}

// Scanner interface
interface Scanner {
    void connect();
}

// Class implementing both interfaces and one connect() implementation
class AllInOneMachine implements Printer, Scanner {
    @Override
    public void connect() {
        System.out.println("AllInOneMachine connected (printer & scanner).");
    }
}

// Test class
public class TestMultipleInterfaces {
    public static void main(String[] args) {
        Printer p = new AllInOneMachine();
        p.connect(); // Uses AllInOneMachine's implementation

        Scanner s = new AllInOneMachine();
        s.connect(); // Uses AllInOneMachine's implementation

        AllInOneMachine machine = new AllInOneMachine();
        machine.connect(); // Same implementation
    }
}
