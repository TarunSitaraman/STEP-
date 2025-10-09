// Abstract base class
abstract class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Abstract method for subclasses to provide specific logic
    public abstract void calculateInterest();

    // Concrete method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }
}

// SavingsAccount subclass
class SavingsAccount extends BankAccount {
    private double rate = 0.04; // 4% interest

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * rate;
        System.out.println("Savings Account Interest: " + interest);
    }
}

// CurrentAccount subclass
class CurrentAccount extends BankAccount {
    private double rate = 0.01; // 1% interest

    public CurrentAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * rate;
        System.out.println("Current Account Interest: " + interest);
    }
}

// Test class for demonstration
public class TestBank {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(10000);
        sa.deposit(2000);
        sa.calculateInterest();

        System.out.println("---");

        CurrentAccount ca = new CurrentAccount(8000);
        ca.deposit(1000);
        ca.calculateInterest();
    }
}
