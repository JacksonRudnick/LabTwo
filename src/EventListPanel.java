import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
	ArrayList<Event> events;
	JPanel controlPanel;
	JPanel displayPanel;
	JComboBox eventComboBox;
	JCheckBox filterDisplay;
	JButton addEventButton;

	EventListPanel() {
		events = new ArrayList<>();

		this.setSize(600, 300);
		this.setLayout(new BorderLayout());

		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(0, 1));
		displayPanel.setPreferredSize(new Dimension(550, 300));

		controlPanel = new JPanel();
		addEventButton = new JButton("Add Event");
		addEventButton.setSize(50, 50);
		controlPanel.add(addEventButton);

		this.add(displayPanel);
		this.add(controlPanel, BorderLayout.EAST);
	}

	public void addEventPanel(EventPanel eventPanel) {
		events.add(eventPanel.getEvent());
		this.add(eventPanel);
	}

}
