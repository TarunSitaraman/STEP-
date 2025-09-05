class Patient {
    String patientId, name;
    int age;
    String medicalHistory;
    Patient(String patientId, String name, int age, String medHist) {
        this.patientId = patientId; this.name = name; this.age = age; medicalHistory = medHist;
    }
}

class Doctor {
    String doctorId, name, specialization;
    Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId; this.name = name; this.specialization = specialization;
    }
}

class Appointment {
    Patient patient; Doctor doctor;
    String date, time;
    Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient; this.doctor = doctor; this.date = date; this.time = time;
    }
}

class Treatment {
    String description; double cost;
    Treatment(String description, double cost) {
        this.description = description; this.cost = cost;
    }
}

class Billing {
    Appointment appointment;
    Treatment[] treatments;
    double totalCost;
    Billing(Appointment appointment, Treatment[] treatments) {
        this.appointment = appointment; this.treatments = treatments;
        totalCost = computeTotal();
    }
    double computeTotal() {
        double sum = 0;
        for (Treatment t : treatments) sum += t.cost;
        return sum;
    }
}

class HospitalManager {
    Patient[] patients = new Patient[16];
    Doctor[] doctors = new Doctor[17];
    Appointment[] appointments = new Appointment[16];
    Billing[] bills = new Billing[16];
    int pCount = 0, dCount = 0, aCount = 0, bCount = 0;

    void addPatient(String id, String name, int age, String mHist) {
        patients[pCount++] = new Patient(id, name, age, mHist);
    }
    void addDoctor(String id, String name, String spec) {
        doctors[dCount++] = new Doctor(id, name, spec);
    }
    Patient findPatient(String id) {
        for (int i = 0; i < pCount; i++)
            if (patients[i].patientId.equals(id)) return patients[i];
        return null;
    }
    Doctor findDoctor(String id) {
        for (int i = 0; i < dCount; i++)
            if (doctors[i].doctorId.equals(id)) return doctors[i];
        return null;
    }
    void bookAppointment(String patId, String docId, String date, String time) {
        Patient pat = findPatient(patId); Doctor doc = findDoctor(docId);
        appointments[aCount++] = new Appointment(pat, doc, date, time);
        System.out.println("Booked appointment for " + pat.name + " with Dr. " + doc.name + " on " + date + " at " + time);
    }
    void processBilling(int appIndex, Treatment[] treatments) {
        bills[bCount++] = new Billing(appointments[appIndex], treatments);
        System.out.println("Billing done for appointment #" + appIndex + " Total: ₹" + bills[bCount - 1].totalCost);
    }
    void showBills() {
        for (int i = 0; i < bCount; i++) {
            System.out.println("Patient: " + bills[i].appointment.patient.name +
                ", Doctor: " + bills[i].appointment.doctor.name +
                ", Date: " + bills[i].appointment.date +
                ", Bill: ₹" + bills[i].totalCost);
        }
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        HospitalManager hm = new HospitalManager();
        hm.addPatient("P01", "Arjun", 30, "Diabetes");
        hm.addDoctor("D01", "Meena", "Cardiology");

        hm.bookAppointment("P01", "D01", "2025-09-15", "10:00 AM");
        Treatment[] treatments = { new Treatment("Consultation", 400.0), new Treatment("ECG", 250.0)};
        hm.processBilling(0, treatments);
        hm.showBills();
    }
}
