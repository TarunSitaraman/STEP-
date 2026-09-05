public class TestAccountEnhanced {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" ENHANCED ACCOUNT TEST (BOOLEAN RETURNS)");
        System.out.println("============================================================");

        System.out.println("\n>>> Test 1: Valid Account Creation");
        AccountEnhanced acc1 = new AccountEnhanced(1001, "John Doe", 25, 1000.0, "Savings");
        System.out.println(formatAccount(acc1));

        System.out.println("\n>>> Test 2: Invalid Age (under 18)");
        System.out.println("Creating account with age 16");
        AccountEnhanced acc2 = new AccountEnhanced(1002, "Young Kid", 16, 500.0, "Savings");
        System.out.println("Age auto-corrected to: " + acc2.getAge());
        System.out.println(formatAccount(acc2));

        System.out.println("\n>>> Test 3: Invalid Account Type");
        System.out.println("Creating account with type \"Invalid\"");
        AccountEnhanced acc3 = new AccountEnhanced(1003, "Test User", 25, 500.0, "Invalid");
        System.out.println("Account type defaulted to: " + acc3.getAccountType());
        System.out.println(formatAccount(acc3));

        System.out.println("\n>>> Test 4: Minimum Balance Enforcement on Creation");
        System.out.println("Creating Savings account with \u20b9300 (below minimum)");
        AccountEnhanced acc4 = new AccountEnhanced(1004, "Bob Wilson", 25, 300.0, "Savings");
        System.out.println("Balance auto-corrected to minimum: \u20b9" + String.format("%.1f", acc4.getBalance()));
        System.out.println(formatAccount(acc4));

        System.out.println("\n>>> Test 5: Withdrawal with Minimum Balance");
        AccountEnhanced acc5 = new AccountEnhanced(1005, "Alice Brown", 30, 1000.0, "Current");
        acc5.setPin(1234);
        System.out.println("Initial: " + formatAccount(acc5));
        if (acc5.withdraw(200.0, 1234)) {
            System.out.println("Withdrawing \u20b9200.0: SUCCESS");
        } else {
            System.out.println("Withdrawing \u20b9200.0: FAILED");
        }
        System.out.println("New balance: \u20b9" + String.format("%.1f", acc5.getBalance()));
        System.out.println("After withdrawal: " + formatAccount(acc5));
        if (acc5.withdraw(900.0, 1234)) {
            System.out.println("Withdrawing \u20b9900.0: SUCCESS");
        } else {
            System.out.println("Withdrawing \u20b9900.0 (would leave \u20b9" + String.format("%.1f", acc5.getBalance() - 900.0) + "): FAILED (Minimum balance violation)");
        }
        System.out.println("Current balance: \u20b9" + String.format("%.1f", acc5.getBalance()));

        System.out.println("\n>>> Test 6: Account Status Management");
        AccountEnhanced acc6 = new AccountEnhanced(1006, "Charlie Green", 35, 2000.0, "Savings");
        System.out.println("Initial: " + formatAccount(acc6));
        if (acc6.closeAccount()) {
            System.out.println("Closing account: SUCCESS");
        }
        System.out.println("After close: " + formatAccount(acc6));
        if (acc6.deposit(500.0)) {
            System.out.println("Depositing \u20b9500.0 to closed account: SUCCESS");
        } else {
            System.out.println("Depositing \u20b9500.0 to closed account: FAILED (Account inactive)");
        }
        if (acc6.reopenAccount()) {
            System.out.println("Reopening account: SUCCESS");
        }
        System.out.println("After reopen: " + formatAccount(acc6));

        System.out.println("\n>>> Test 7: PIN Protection");
        AccountEnhanced acc7 = new AccountEnhanced(1007, "Diana Prince", 28, 1500.0, "Savings");
        if (acc7.setPin(1234)) {
            System.out.println("Setting PIN 1234: SUCCESS");
        }
        if (acc7.withdraw(200.0, 1234)) {
            System.out.println("Withdrawing \u20b9200.0 with correct PIN (1234): SUCCESS");
        } else {
            System.out.println("Withdrawing \u20b9200.0 with correct PIN (1234): FAILED");
        }
        System.out.println("New balance: \u20b9" + String.format("%.1f", acc7.getBalance()));
        if (acc7.withdraw(100.0, 9999)) {
            System.out.println("Withdrawing \u20b9100.0 with incorrect PIN (9999): SUCCESS");
        } else {
            System.out.println("Withdrawing \u20b9100.0 with incorrect PIN (9999): FAILED (Incorrect PIN)");
        }
        AccountEnhanced acc8 = new AccountEnhanced(1008, "Test No Pin", 30, 1000.0, "Savings");
        if (acc8.withdraw(100.0, 0)) {
            System.out.println("Withdrawing \u20b9100.0 with PIN not set: SUCCESS");
        } else {
            System.out.println("Withdrawing \u20b9100.0 with PIN not set: FAILED (PIN not set)");
        }

        System.out.println("\n>>> Test 8: All Accounts Summary");
        System.out.println(formatAccount(acc1));
        System.out.println(formatAccount(acc2));
        System.out.println(formatAccount(acc3));
        System.out.println(formatAccount(acc4));
        System.out.println(formatAccount(acc5));
        System.out.println(formatAccount(acc6));
        System.out.println(formatAccount(acc7));
        System.out.println("============================================================");
        System.out.println(" ENHANCED TEST COMPLETED!");
        System.out.println("============================================================");
    }

    static String formatAccount(AccountEnhanced acc) {
        String pinStatus = acc.hasPin() ? "Yes" : "No";
        return "Account #" + acc.getAccountNumber() + " | " + acc.getName() + " (" + acc.getAge() + " yrs) | "
                + acc.getAccountType() + " | \u20b9" + String.format("%.1f", acc.getBalance()) + " | "
                + acc.getStatus() + " | PIN: " + pinStatus;
    }
}
