abstract class BankAccount {
    String accountNumber;
    String holderName;
    double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    abstract void processTransaction(double amount);

    double calculateFee(double amount) { return 0; }
    double calculateFee(double amount, double flatFee) { return flatFee; }

    void showAccountSummary() {
        System.out.println(holderName + " (" + accountNumber + ") - Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;
    double withdrawalLimit;
    SavingsAccount(String acc, String name, double bal, double rate, double limit) {
        super(acc, name, bal);
        this.interestRate = rate;
        this.withdrawalLimit = limit;
    }
    @Override
    void processTransaction(double amount) {
        if (amount < 0 && Math.abs(amount) > withdrawalLimit) {
            System.out.println("Withdrawal exceeds limit.");
        } else {
            balance += amount;
            System.out.println("Savings transaction processed. New balance: ₹" + balance);
        }
    }
    @Override
    double calculateFee(double amount) {
        return amount > 50000 ? 50 : 10;
    }
    void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added. New balance: ₹" + balance);
    }
}

class CheckingAccount extends BankAccount {
    double overdraftLimit;
    double monthlyFee;
    CheckingAccount(String acc, String name, double bal, double overdraft, double monthlyFee) {
        super(acc, name, bal);
        this.overdraftLimit = overdraft;
        this.monthlyFee = monthlyFee;
    }
    @Override
    void processTransaction(double amount) {
        if (balance + overdraftLimit + amount < 0) {
            System.out.println("Overdraft limit exceeded.");
        } else {
            balance += amount;
            System.out.println("Checking transaction processed. New balance: ₹" + balance);
        }
    }
    @Override
    double calculateFee(double amount) {
        return (amount < 0) ? 25 : 0;
    }
    double calculateFee(double amount, boolean waiveFee) {
        return waiveFee ? 0 : calculateFee(amount);
    }
}

class InvestmentAccount extends BankAccount {
    String portfolioType;
    String riskLevel;
    InvestmentAccount(String acc, String name, double bal, String type, String risk) {
        super(acc, name, bal);
        this.portfolioType = type;
        this.riskLevel = risk;
    }
    @Override
    void processTransaction(double amount) {
        balance += amount;
        System.out.println("Investment transaction processed. New balance: ₹" + balance);
    }
    void assessRisk() {
        System.out.println("Risk assessment for " + holderName + ": " + riskLevel);
    }
}

class BusinessAccount extends BankAccount {
    int pendingBulkTransactions;
    BusinessAccount(String acc, String name, double bal, int bulkTx) {
        super(acc, name, bal);
        this.pendingBulkTransactions = bulkTx;
    }
    @Override
    void processTransaction(double amount) {
        balance += amount;
        System.out.println("Business transaction processed. New balance: ₹" + balance);
    }
    void processBulkTransactions() {
        System.out.println("Processing " + pendingBulkTransactions + " bulk business transactions.");
    }
}

public class BankSystem {
    public static void processMixedAccounts(BankAccount[] portfolio) {
        for (BankAccount acct : portfolio) {
            acct.showAccountSummary();
            acct.processTransaction(-1000);
            if (acct instanceof SavingsAccount) {
                ((SavingsAccount)acct).addInterest();
            } else if (acct instanceof CheckingAccount) {
                double fee = ((CheckingAccount)acct).calculateFee(-2000, false);
                System.out.println("Checking account fee: ₹" + fee);
            } else if (acct instanceof InvestmentAccount) {
                ((InvestmentAccount)acct).assessRisk();
            } else if (acct instanceof BusinessAccount) {
                ((BusinessAccount)acct).processBulkTransactions();
            }
            System.out.println("---");
        }
    }

    public static void main(String[] args) {
        BankAccount[] allAccounts = {
            new SavingsAccount("S001", "Anita", 60000, 3.5, 20000),
            new CheckingAccount("C001", "Rohit", 20000, 5000, 40),
            new InvestmentAccount("I001", "Priya", 120000, "Stocks", "Moderate"),
            new BusinessAccount("B001", "TravelCorp", 240000, 12)
        };
        processMixedAccounts(allAccounts);
    }
}
