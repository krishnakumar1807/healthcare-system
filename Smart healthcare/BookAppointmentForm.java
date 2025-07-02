import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BookAppointmentForm extends JFrame {
    public BookAppointmentForm(HealthcareSystem system) {
        setTitle("Book Appointment");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JComboBox<String> patientDropdown = new JComboBox<>();
        JComboBox<String> doctorDropdown = new JComboBox<>();
        JTextField dateField = new JTextField();

        // Populate patient list
        List<Patient> patients = system.getAllPatients();
        for (Patient p : patients) {
            patientDropdown.addItem(p.getName());
        }

        // Populate doctor list
        List<Doctor> doctors = system.getAllDoctors();
        for (Doctor d : doctors) {
            doctorDropdown.addItem(d.getName() + " - " + d.getSpecialty());
        }

        panel.add(new JLabel("Select Patient:"));
        panel.add(patientDropdown);

        panel.add(new JLabel("Select Doctor:"));
        panel.add(doctorDropdown);

        panel.add(new JLabel("Date (yyyy-mm-dd):"));
        panel.add(dateField);

        JButton bookButton = new JButton("Book");
        panel.add(bookButton);

        bookButton.addActionListener(e -> {
            String patientName = (String) patientDropdown.getSelectedItem();
            String doctorEntry = (String) doctorDropdown.getSelectedItem();
            String date = dateField.getText().trim();

            if (patientName == null || doctorEntry == null || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            Patient patient = system.findPatientByName(patientName);
            Doctor doctor = system.findDoctorByName(doctorEntry.split(" - ")[0]);

            if (patient != null && doctor != null) {
                system.bookAppointment(patient, doctor, date);
                JOptionPane.showMessageDialog(this, "Appointment booked.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid patient or doctor selection.");
            }
        });

        add(panel);
        setVisible(true);
    }
}
