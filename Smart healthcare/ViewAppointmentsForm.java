import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewAppointmentsForm extends JFrame {
    public ViewAppointmentsForm(HealthcareSystem system) {
        setTitle("Appointments List");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        StringBuilder sb = new StringBuilder();
        for (Appointment a : system.getAppointments()) {
            sb.append("Patient: ").append(a.getPatient().getName())
              .append(", Doctor: ").append(a.getDoctor().getName())
              .append(", Date: ").append(a.getDate())
              .append("\n");
        }

        area.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(area);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
