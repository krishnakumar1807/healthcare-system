import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewPatientsForm extends JFrame {
    public ViewPatientsForm(HealthcareSystem system) {
        setTitle("View Patients");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea patientsArea = new JTextArea();
        patientsArea.setEditable(false);

        List<Patient> patients = system.getAllPatients();
        if (patients.isEmpty()) {
            patientsArea.setText("No patients found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Patient p : patients) {
                sb.append("Name: ").append(p.getName())
                  .append(", Age: ").append(p.getAge())
                  .append(", Gender: ").append(p.getGender())
                  .append(", Issue: ").append(p.getIssue())
                  .append("\n");
            }
            patientsArea.setText(sb.toString());
        }

        JScrollPane scrollPane = new JScrollPane(patientsArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
