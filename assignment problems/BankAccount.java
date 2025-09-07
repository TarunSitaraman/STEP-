public class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Default constructor
    public BankAccount() {
        this("Unknown", 0, 0.0);
    }

    // Constructor with name and random account number
    public BankAccount(String name) {
        this(name, (int)(Math.random() * 100000), 0.0);
    }

    // Constructor with name and initial balance
    public BankAccount(String name, double initialBalance) {
        this(name, (int)(Math.random() * 100000), initialBalance);
    }

    // Full constructor
    public BankAccount(String name, int accNum, double balance) {
        this.accountHolder = name;
        this.accountNumber = accNum;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Display account details
    public void displayAccount() {
        System.out.println("Holder: " + accountHolder +
            ", Acc No: " + accountNumber +
            ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Alice");
        BankAccount a3 = new BankAccount("Bob", 5000.0);

        a2.deposit(2500);
        a3.withdraw(1000);

        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}
