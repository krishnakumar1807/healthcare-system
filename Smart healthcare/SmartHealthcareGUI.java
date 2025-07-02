import javax.swing.*;
import java.awt.*;

public class SmartHealthcareGUI {
    private JFrame frame;
    private HealthcareSystem system;

    public SmartHealthcareGUI(HealthcareSystem system) {
        this.system = system;
    }

    public void launch() {
        initialize();
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Smart Healthcare System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(0, 1, 10, 10));

        JButton addPatientButton = new JButton("Add Patient");
        addPatientButton.addActionListener(e -> new AddPatientForm(system));
        panel.add(addPatientButton);

        JButton bookAppointmentButton = new JButton("Book Appointment");
        bookAppointmentButton.addActionListener(e -> new BookAppointmentForm(system));
        panel.add(bookAppointmentButton);

        JButton viewAppointmentsButton = new JButton("View Appointments");
        viewAppointmentsButton.addActionListener(e -> new ViewAppointmentsForm(system));
        panel.add(viewAppointmentsButton);

        JButton viewPatientsButton = new JButton("View Patients");
        viewPatientsButton.addActionListener(e -> new ViewPatientsForm(system));
         panel.add(viewPatientsButton);

         JButton addDoctorButton = new JButton("Add Doctor");
addDoctorButton.addActionListener(e -> new AddDoctorForm(system));
panel.add(addDoctorButton);


        JButton viewDoctorsButton = new JButton("View Doctors");
viewDoctorsButton.addActionListener(e -> new ViewDoctorsForm(system));
panel.add(viewDoctorsButton);
 
         panel.add(addPatientButton);
panel.add(bookAppointmentButton);
panel.add(viewAppointmentsButton);
panel.add(viewPatientsButton); 


    }
}
