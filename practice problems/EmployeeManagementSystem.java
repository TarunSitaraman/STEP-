import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public double getSalary() { return salary; }
    public void showInfo() {
        System.out.println(id + " | " + name + " | " + dept + " | " + salary);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[100];
        int count = 0;

        while (true) {
            System.out.println("\n1. Add Employee  2. Show All  3. Search by ID  4. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // consume newline
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Dept: ");
                String dept = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                employees[count++] = new Employee(id,name,dept,salary);
                System.out.println("Employee Added.");
            } else if (choice == 2) {
                for (int i = 0; i < count; i++) employees[i].showInfo();
            } else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (employees[i].getId() == id) {
                        employees[i].showInfo();
                        found = true;
                    }
                }
                if (!found) System.out.println("Not Found.");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid.");
            }
        }
        sc.close();
    }
}
