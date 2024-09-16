import javax.swing.*;
import java.awt.*;

public class AddEventModal extends JDialog {
	AddEventModal(JFrame frame) {
		super(frame, "Add Event", true);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		this.add(panel);
	}


}
