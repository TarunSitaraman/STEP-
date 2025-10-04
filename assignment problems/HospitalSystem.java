class MedicalStaff {
    String name;
    int staffID;
    
    MedicalStaff(String name, int staffID) {
        this.name = name;
        this.staffID = staffID;
    }
    
    void scheduleShift() {
        System.out.println(name + " scheduled for standard staff shift.");
    }
    void accessIDCard() {
        System.out.println("ID card activated for " + name + ", Staff ID: " + staffID);
    }
    void processPayroll() {
        System.out.println("Payroll processed for " + name);
    }
}

class Doctor extends MedicalStaff {
    Doctor(String name, int staffID) { super(name, staffID); }
    
    void diagnosePatient() {
        System.out.println(name + " diagnoses patient.");
    }
    void prescribeMedicine() {
        System.out.println(name + " prescribes medicine.");
    }
    void performSurgery() {
        System.out.println(name + " performs surgery.");
    }
}

class Nurse extends MedicalStaff {
    Nurse(String name, int staffID) { super(name, staffID); }
    
    void administerMedicine() {
        System.out.println(name + " administers medicine.");
    }
    void monitorPatient() {
        System.out.println(name + " monitors patient.");
    }
    void assistProcedure() {
        System.out.println(name + " assists in procedure.");
    }
}

class Technician extends MedicalStaff {
    Technician(String name, int staffID) { super(name, staffID); }
    
    void operateEquipment() {
        System.out.println(name + " operates medical equipment.");
    }
    void runTests() {
        System.out.println(name + " runs diagnostic test.");
    }
    void maintainInstruments() {
        System.out.println(name + " maintains hospital instruments.");
    }
}

class Administrator extends MedicalStaff {
    Administrator(String name, int staffID) { super(name, staffID); }
    
    void scheduleAppointment() {
        System.out.println(name + " schedules appointment.");
    }
    void manageRecords() {
        System.out.println(name + " manages medical records.");
    }
}

public class HospitalSystem {
    static void processStaffCommon(MedicalStaff staff) {
        staff.scheduleShift();
        staff.accessIDCard();
        staff.processPayroll();
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        MedicalStaff[] staffList = {
            new Doctor("Dr. Rao", 1001),
            new Nurse("Ms. Singh", 1002),
            new Technician("Mr. Patel", 1003),
            new Administrator("Mrs. Iyer", 1004)
        };

        for (MedicalStaff staff : staffList) {
            processStaffCommon(staff);  // Upcasting in action
        }
        // Downcast for specialized actions if needed
        ((Doctor)staffList[0]).performSurgery();
        ((Nurse)staffList[1]).assistProcedure();
        ((Technician)staffList[2]).runTests();
        ((Administrator)staffList[3]).manageRecords();
    }
}
