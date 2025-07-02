import java.util.ArrayList;
import java.util.List;

public class HealthcareSystem {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Patient findPatientByName(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public Doctor findDoctorByName(String name) {
        for (Doctor d : doctors) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public void bookAppointment(Patient patient, Doctor doctor, String date) {
        appointments.add(new Appointment(patient, doctor, date));
    }

    // You can also add this for compatibility with older code
    public List<Doctor> getDoctors() {
        return getAllDoctors();
    }

    public List<Patient> getPatients() {
        return getAllPatients();
    }
}
