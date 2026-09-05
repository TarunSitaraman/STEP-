public class AccountEnhanced {
    private int accountNumber;
    private String name;
    private int age;
    private double balance;
    private String accountType;
    private String status;
    private Integer pin;

    public AccountEnhanced(int accountNumber, String name, int age, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.age = age;
        if (this.age < 18) {
            this.age = 18;
        }
        if (accountType.equals("Savings") || accountType.equals("Current")) {
            this.accountType = accountType;
        } else {
            this.accountType = "Savings";
        }
        double minBalance = this.accountType.equals("Savings") ? 500.0 : 1000.0;
        if (initialBalance < minBalance) {
            this.balance = minBalance;
        } else {
            this.balance = initialBalance;
        }
        this.status = "Active";
        this.pin = null;
    }

    public boolean deposit(double amount) {
        if (!status.equals("Active")) {
            return false;
        }
        if (amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount, int pin) {
        if (!status.equals("Active")) {
            return false;
        }
        if (this.pin == null || !verifyPin(pin)) {
            return false;
        }
        if (amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public boolean closeAccount() {
        if (status.equals("Inactive")) {
            return false;
        }
        status = "Inactive";
        return true;
    }

    public boolean reopenAccount() {
        if (status.equals("Active")) {
            return false;
        }
        status = "Active";
        return true;
    }

    public boolean setPin(int pin) {
        if (pin < 1000 || pin > 9999) {
            return false;
        }
        this.pin = pin;
        return true;
    }

    public boolean verifyPin(int pin) {
        if (this.pin == null) {
            return false;
        }
        return this.pin == pin;
    }

    public boolean hasPin() {
        return this.pin != null;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
