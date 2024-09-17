import javax.swing.*;
import java.awt.*;

public class AddEventModal extends JDialog {
    AddEventModal() {
        setTitle("Add Event");
        setSize(400, 400);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Event Name"));
        add(new JTextField());
        add(new JLabel("Event Date"));
        add(new JTextField());
        add(new JLabel("Event Time"));
        add(new JTextField());
        add(new JButton("Add Event"));
        setVisible(true);
    }
}
