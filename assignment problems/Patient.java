import java.time.LocalDate;
import java.util.*;

// Immutable MedicalRecord
final class MedicalRecord {
    private final String recordId;
    private final String patientDNA;
    private final String[] allergies;
    private final String[] medicalHistory;
    private final LocalDate birthDate;
    private final String bloodType;

    public MedicalRecord(String recordId, String patientDNA, String[] allergies, String[] medicalHistory,
                        LocalDate birthDate, String bloodType) {
        if (recordId == null || patientDNA == null || birthDate == null || bloodType == null)
            throw new IllegalArgumentException("Missing required fields");
        this.recordId = recordId;
        this.patientDNA = patientDNA;
        this.allergies = allergies != null ? Arrays.copyOf(allergies, allergies.length) : new String[0];
        this.medicalHistory = medicalHistory != null ? Arrays.copyOf(medicalHistory, medicalHistory.length) : new String[0];
        this.birthDate = birthDate;
        this.bloodType = bloodType;
    }

    public String getRecordId() { return recordId; }
    public String getPatientDNA() { return patientDNA; }
    public String[] getAllergies() { return Arrays.copyOf(allergies, allergies.length); }
    public String[] getMedicalHistory() { return Arrays.copyOf(medicalHistory, medicalHistory.length); }
    public LocalDate getBirthDate() { return birthDate; }
    public String getBloodType() { return bloodType; }

    public final boolean isAllergicTo(String substance) {
        for (String a : allergies) if (substance != null && substance.equalsIgnoreCase(a)) return true;
        return false;
    }
}

// Patient with privacy levels
public class Patient {
    private final String patientId;
    private final MedicalRecord medicalRecord;
    private String name, emergencyContact, insuranceInfo, attendingPhysician;
    private int roomNumber;

    // Emergency admission
    public Patient(String name, String emergencyContact) {
        this.patientId = "TEMP-" + UUID.randomUUID();
        this.name = name;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = "";
        this.attendingPhysician = "";
        this.roomNumber = -1;
        this.medicalRecord = null;
    }

    // Full admission
    public Patient(String patientId, MedicalRecord medicalRecord, String name, String emergencyContact,
                   String insuranceInfo, int roomNumber, String attendingPhysician) {
        if (patientId == null || medicalRecord == null) throw new IllegalArgumentException();
        this.patientId = patientId;
        this.medicalRecord = medicalRecord;
        this.name = name;
        this.emergencyContact = emergencyContact;
        this.insuranceInfo = insuranceInfo;
        this.roomNumber = roomNumber;
        this.attendingPhysician = attendingPhysician;
    }

    String getBasicInfo() { return name + ", Room: " + roomNumber; }
    public String getPublicInfo() { return "Patient: " + name + ", Room: " + roomNumber; }

    // Simple setters
    public void setName(String name) { if (name!=null && !name.isBlank()) this.name = name; }
    public void setEmergencyContact(String c) { this.emergencyContact = c; }
    public void setInsuranceInfo(String i) { this.insuranceInfo = i; }
    public void setRoomNumber(int n) { if (n > 0) this.roomNumber = n; }
    public void setAttendingPhysician(String doctor) { this.attendingPhysician = doctor; }

    public String getName() { return name; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
}

// Staff classes
class Doctor {
    private final String license, specialty;
    public Doctor(String lic, String sp) { license=lic; specialty=sp; }
}

class Nurse {
    private final String id, shift;
    public Nurse(String id, String shift) { this.id=id; this.shift=shift; }
}

class Administrator {
    private final String id;
    public Administrator(String id) { this.id=id; }
}

// HospitalSystem with access control
class HospitalSystem {
    private final Map<String, Patient> registry = new HashMap<>();
    static final String PRIVACY_POLICY = "Patients' data is confidential.";

    public boolean admitPatient(Patient patient, Object staff) {
        if (staff instanceof Doctor || staff instanceof Nurse || staff instanceof Administrator) {
            registry.put(patient.getName(), patient);
            return true;
        }
        return false;
    }

    Patient getPatient(String name) { return registry.get(name); }
}

