import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
	ArrayList<Event> events;
	JPanel controlPanel;
	JPanel displayPanel;
	JPanel alignmentPanel;
	JComboBox eventComboBox;
	JCheckBox filterDisplay;
	JButton addEventButton;

	EventListPanel() {
		//init array
		events = new ArrayList<>();

		//basics of event list panel
		this.setSize(600, 300);
		this.setLayout(new BorderLayout());

		//alignment panel for the display panel
		alignmentPanel = new JPanel();
		alignmentPanel.setLayout(new BorderLayout());
		this.add(alignmentPanel, BorderLayout.CENTER);

		//display panel to list events
		displayPanel = new JPanel();
		displayPanel.setLayout(new GridLayout(-1, 1));
		alignmentPanel.add(displayPanel, BorderLayout.NORTH);

		//control panel settings and additions
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		addEventButton = new JButton("Add Event");
		//addEventButton.addActionListener(e -> {})
		controlPanel.add(addEventButton);

		eventComboBox = new JComboBox();
		eventComboBox.setMinimumSize(new Dimension(100, -1));
		controlPanel.add(eventComboBox);

		filterDisplay = new JCheckBox("Filter Display");
		controlPanel.add(filterDisplay);

		add(controlPanel, BorderLayout.NORTH);
	}

	public void addEventPanel(EventPanel eventPanel) {
		events.add(eventPanel.getEvent());

		displayPanel.add(eventPanel);
	}
}
