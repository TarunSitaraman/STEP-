class Employee {
    String name;
    String type;

    // Constructor
    Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Overloaded method for full-time employee
    double calculateSalary(double monthlySalary) {
        return monthlySalary;
    }

    // Overloaded method for part-time employee
    double calculateSalary(double hourlyRate, int hoursWorked) {
        return hourlyRate * hoursWorked;
    }

    // Overloaded method for contract employee
    double calculateSalary(double monthlySalary, double bonus) {
        return monthlySalary + bonus;
    }

    void printEmployeeDetails() {
        System.out.println("Name: " + name + ", Type: " + type);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Arjun", "Full-Time");
        Employee e2 = new Employee("Meena", "Part-Time");
        Employee e3 = new Employee("Raj", "Contract");

        e1.printEmployeeDetails();
        System.out.println("Salary: " + e1.calculateSalary(30000));

        e2.printEmployeeDetails();
        System.out.println("Salary: " + e2.calculateSalary(500, 80));

        e3.printEmployeeDetails();
        System.out.println("Salary: " + e3.calculateSalary(25000, 5000));
    }
}
