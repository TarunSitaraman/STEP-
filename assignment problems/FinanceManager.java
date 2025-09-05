class Transaction {
    String type; // "Income" or "Expense"
    String description;
    double amount;
    String date;

    Transaction(String type, String description, double amount, String date) {
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}

public class FinanceManager {
    Transaction[] transactions = new Transaction[100];
    int count = 0;

    void addTransaction(String type, String desc, double amount, String date) {
        transactions[count++] = new Transaction(type, desc, amount, date);
    }

    void viewTransactions() {
        System.out.println("Date\tType\tDescription\tAmount");
        for (int i = 0; i < count; i++) {
            System.out.println(
                transactions[i].date + "\t" +
                transactions[i].type + "\t" +
                transactions[i].description + "\t" +
                transactions[i].amount
            );
        }
    }

    double getTotal(String type) {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (transactions[i].type.equals(type)) {
                total += transactions[i].amount;
            }
        }
        return total;
    }

    double getSavings() {
        return getTotal("Income") - getTotal("Expense");
    }
}

class Main {
    public static void main(String[] args) {
        FinanceManager fm = new FinanceManager();
        fm.addTransaction("Income", "Salary", 40000, "2025-09-01");
        fm.addTransaction("Expense", "Rent", 10000, "2025-09-02");
        fm.addTransaction("Expense", "Groceries", 3500, "2025-09-03");
        fm.addTransaction("Income", "Freelance", 8000, "2025-09-04");

        fm.viewTransactions();
        System.out.println("Total Income: " + fm.getTotal("Income"));
        System.out.println("Total Expense: " + fm.getTotal("Expense"));
        System.out.println("Current Savings: " + fm.getSavings());
    }
}
