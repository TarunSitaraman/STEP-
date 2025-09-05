public class BankAccount {
    static String bankName = "Global Bank";
    static int totalAccounts = 0;
    static double interestRate = 3.5; 
    
    String accountNumber;
    String accountHolder;
    double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        totalAccounts++;
    }

    public static void setBankName(String name) {
        bankName = name;
    }
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    public static int getTotalAccounts(){
        return totalAccounts;
    }
    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void calculateInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
public static void main(String[] args) {
    BankAccount acc1 = new BankAccount("A123", "Tarun", 100000);
    BankAccount acc2 = new BankAccount("B456", "Sachin", 20000);
    acc1.deposit(5000);
    acc2.withdraw(2000);
    acc1.calculateInterest();
    acc2.calculateInterest();
    acc1.displayAccountInfo();
    acc2.displayAccountInfo();
    BankAccount.displayBankInfo();
    }
}