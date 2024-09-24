import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
	ArrayList<Event> events;
	JPanel controlPanel;
	JPanel displayPanel;
	JPanel alignmentPanel;
	JComboBox eventComboBox;
	JCheckBox completedFilter;
    JCheckBox deadlineFilter;
    JCheckBox meetingFilter;
	JButton addEventButton;
	AddEventModal addEventModal;

	EventListPanel(JFrame frame) {
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
		addEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEventModal = new AddEventModal(EventListPanel.this);
			}
		});
		controlPanel.add(addEventButton);

		eventComboBox = new JComboBox(new String[] {"Name", "Date", "Name: reverse", "Date: reverse"});
		controlPanel.add(eventComboBox);

        eventComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = eventComboBox.getSelectedItem().toString();

                switch (selected) {
                    case "Name":
                        events.sort((a, b) -> a.getName().compareTo(b.getName()));
                        break;
                    case "Date":
                        events.sort((a, b) -> a.getDateTime().compareTo(b.getDateTime()));
                        break;
                    case "Name: reverse":
                        events.sort((a, b) -> b.getName().compareTo(a.getName()));
                        break;
                    case "Date: reverse":
                        events.sort((a, b) -> b.getDateTime().compareTo(a.getDateTime()));
                        break;
                }

                refreshDisplay();
            }
        });

		completedFilter = new JCheckBox("Remove Completed");
		controlPanel.add(completedFilter);

        deadlineFilter = new JCheckBox("Deadlines only");
        controlPanel.add(deadlineFilter);

        meetingFilter = new JCheckBox("Meetings only");
        controlPanel.add(meetingFilter);

		add(controlPanel, BorderLayout.NORTH);
	}

    public void refreshDisplay() {
        displayPanel.removeAll();

        for (Event event : events) {
            EventPanel eventPanel = new EventPanel(event);
            displayPanel.add(eventPanel);
        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }

	public void addEventPanel(EventPanel eventPanel) {
        events.add(eventPanel.getEvent());

		displayPanel.add(eventPanel);
	}
}
