import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewDoctorsForm extends JFrame {
    public ViewDoctorsForm(HealthcareSystem system) {
        setTitle("Doctors List");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Doctor> doctors = system.getDoctors();

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Doctor d : doctors) {
            listModel.addElement("Name: " + d.getName() + ", Specialty: " + d.getSpecialty());
        }

        JList<String> doctorList = new JList<>(listModel);
        add(new JScrollPane(doctorList), BorderLayout.CENTER);

        setVisible(true);
    }
}
