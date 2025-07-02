import javax.swing.*;
import java.awt.*;

public class AddDoctorForm extends JFrame {
    public AddDoctorForm(HealthcareSystem system) {
        setTitle("Add Doctor");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel specializationLabel = new JLabel("Specialization:");
        JTextField specializationField = new JTextField();

        JLabel contactLabel = new JLabel("Contact:");
        JTextField contactField = new JTextField();

        JButton submitButton = new JButton("Add Doctor");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String specialization = specializationField.getText();
            String contact = contactField.getText();

            if (!name.isEmpty() && !specialization.isEmpty()) {
                Doctor doctor = new Doctor(name, specialization);
                system.addDoctor(doctor);
                JOptionPane.showMessageDialog(this, "Doctor added successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "All fields are required.");
            }
        });

        add(nameLabel);
        add(nameField);
        add(specializationLabel);
        add(specializationField);
        add(new JLabel());
        add(submitButton);

        setVisible(true);
    }
}
