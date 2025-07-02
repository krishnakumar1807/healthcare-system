import javax.swing.*;
import java.awt.*;

public class AddPatientForm extends JFrame {
    public AddPatientForm(HealthcareSystem system) {
        setTitle("Add New Patient");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});
        JTextField issueField = new JTextField();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        panel.add(genderBox);

        panel.add(new JLabel("Issue:"));
        panel.add(issueField);

        JButton addButton = new JButton("Add Patient");
        panel.add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String gender = (String) genderBox.getSelectedItem();
            String issue = issueField.getText().trim();

            if (name.isEmpty() || ageText.isEmpty() || issue.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                Patient patient = new Patient(name, age, gender, issue);
                system.addPatient(patient);
                JOptionPane.showMessageDialog(this, "Patient added successfully.");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a number.");
            }
        });

        add(panel);
        setVisible(true);
    }
}
