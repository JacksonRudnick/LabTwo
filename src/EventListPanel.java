//imports
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EventListPanel extends JPanel {
	//all variables needed
    ArrayList<Event> events;
    //backup of events for filtering
    ArrayList<Event> undisplayedEvents;
	JPanel controlPanel;
	JPanel displayPanel;
	JPanel alignmentPanel;
	JComboBox eventComboBox;
	JButton addEventButton;
	AddEventModal addEventModal;

    //constructor
	EventListPanel(JFrame frame) {
		//init array
		events = new ArrayList<>();
        undisplayedEvents = new ArrayList<>();

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

        //add event button for modal
		addEventButton = new JButton("Add Event");
		addEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEventModal = new AddEventModal(EventListPanel.this);
			}
		});
		controlPanel.add(addEventButton);

        //event combo box for sorting
		eventComboBox = new JComboBox(new String[] {"Name", "Date", "Name: reverse", "Date: reverse"});
		controlPanel.add(eventComboBox);

        //action listener for sorting
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

        //checkbox for filtering incomplete events
        controlPanel.add(new JCheckBox("Show only incomplete") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JCheckBox checkBox = (JCheckBox) e.getSource();

                        if (checkBox.isSelected()) {
                            events.removeIf(Event::isComplete);
                        } else {
                            events = new ArrayList<>(undisplayedEvents);
                        }

                        refreshDisplay();
                    }
                });
            }
        });

        //checkbox for filtering meetings
        controlPanel.add(new JCheckBox("Show only meetings") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JCheckBox checkBox = (JCheckBox) e.getSource();

                        if (checkBox.isSelected()) {
                            events.removeIf(event -> !(event instanceof Meeting));
                        } else {
                            events = new ArrayList<>(undisplayedEvents);
                        }

                        refreshDisplay();
                    }
                });
            }
        });

        //checkbox for filtering deadlines
        controlPanel.add(new JCheckBox("Show only deadlines") {
            {
                addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JCheckBox checkBox = (JCheckBox) e.getSource();

                        if (checkBox.isSelected()) {
                            events.removeIf(event -> !(event instanceof Deadline));
                        } else {
                            events = new ArrayList<>(undisplayedEvents);
                        }

                        refreshDisplay();
                    }
                });
            }
        });

		add(controlPanel, BorderLayout.NORTH);
	}

    //refresh display to ensure all events in list are displayed
    public void refreshDisplay() {
        displayPanel.removeAll();

        for (Event event : events) {
            EventPanel eventPanel = new EventPanel(event);
            displayPanel.add(eventPanel);
        }

        displayPanel.revalidate();
        displayPanel.repaint();
    }

    //add event panel to display panel and lists
	public void addEventPanel(EventPanel eventPanel) {
        events.add(eventPanel.getEvent());
        undisplayedEvents.add(eventPanel.getEvent());

	    refreshDisplay();
    }
}
