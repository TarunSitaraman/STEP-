import java.util.HashSet;

public class Employee {
    private String empCode;
    private String name;
    
    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Employee employee = (Employee) obj;
        return empCode.equals(employee.empCode);
    }
    
    @Override
    public int hashCode() {
        return empCode.hashCode();
    }
    
    @Override
    public String toString() {
        return "Employee[empCode=" + empCode + ", name=" + name + "]";
    }
}

class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");
        
        System.out.println("e1: " + e1);
        System.out.println("e2: " + e2);
        
        System.out.println("\nComparison Results:");
        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));
        
        System.out.println("\nHashCode Values:");
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e2.hashCode(): " + e2.hashCode());
        
        System.out.println("\nHashSet Test:");
        HashSet<Employee> employeeSet = new HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2);
        System.out.println("HashSet size: " + employeeSet.size());
        System.out.println("HashSet contains: " + employeeSet);
    }
}
