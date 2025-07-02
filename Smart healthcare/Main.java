public class Main {
    public static void main(String[] args) {
        HealthcareSystem system = new HealthcareSystem();
        SmartHealthcareGUI gui = new SmartHealthcareGUI(system);
        gui.launch();
    }
}
