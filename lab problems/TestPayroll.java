// Interface for pay slip generation
interface Payable {
    void generatePaySlip();
}

// Abstract class for core employee details and bonus calculation
abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract double calculateBonus();
}

// Concrete class Manager extends Employee and implements Payable
class Manager extends Employee implements Payable {
    private double bonusRate;

    public Manager(String name, double salary, double bonusRate) {
        super(name, salary);
        this.bonusRate = bonusRate;
    }

    @Override
    public double calculateBonus() {
        return salary * bonusRate;
    }

    @Override
    public void generatePaySlip() {
        System.out.println("Pay Slip for Manager:");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
        System.out.println("Total Pay: " + (salary + calculateBonus()));
    }
}

// Demo class to test functionality
public class TestPayroll {
    public static void main(String[] args) {
        Manager m = new Manager("Alice", 50000, 0.2);
        m.generatePaySlip();
    }
}
