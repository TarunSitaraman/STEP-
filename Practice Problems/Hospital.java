public class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
    }

    public class Department {
        private String deptName;

        public Department(String deptName) {
            this.deptName = deptName;
        }

        public void displayInfo() {
            System.out.println("Department: " + deptName + ", Hospital: " + Hospital.this.name);
        }
    }

    public Department createDepartment(String deptName) {
        return new Department(deptName);
    }
}

class HospitalManagement {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("SRM Hospital");
        Hospital.Department dept1 = hospital.createDepartment("Cardiology");
        Hospital.Department dept2 = hospital.createDepartment("Neurology");

        dept1.displayInfo();
        dept2.displayInfo();
    }
}
