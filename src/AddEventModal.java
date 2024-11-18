//imports
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class AddEventModal extends JDialog {
    //0 not setup, 1 is meeting, 2 is deadline, 3 is setup done
    int setup = 0;

    //Event object modal returns
    Event event;

    //Components
    JPanel displayPanel;
    JComboBox<String> eventType;
    JTextField eventName;
    JTextField eventTime;
    JTextField eventEndTime;
    JTextField eventLocation;
    JButton submitButton;

    EventListPanel eventListPanel;

    //constructor, takes in the event list panel
    AddEventModal(EventListPanel elp) {
        eventListPanel = elp;

        displayPanel = new JPanel();

        eventType = new JComboBox<>(new String[] {"Select One", "Meeting", "Deadline"});
        
        eventName = new JTextField();
        eventTime = new JTextField();
        eventEndTime = new JTextField();
        eventLocation = new JTextField();

        //modal settings
        setTitle("Add Event");
        setSize(400, 400);
        displayPanel.setLayout(new GridLayout(0, 2));
    
        //ask for event type
        displayPanel.add(new JLabel("Event Type"));
        displayPanel.add(eventType);

        //action listener for event type
        eventType.addActionListener(e -> {
            setup = eventType.getSelectedIndex();

            if (setup != 0) {
                displayPanel.removeAll();
                setupModal();
            }
        });
        
        add(displayPanel);
        setVisible(true);
    }

    //setup modal based on event type
    void setupModal() {
        EventFactory eventFactory = new EventFactory();

        //meeting setup
        if (setup == 1) {
            displayPanel.add(new JLabel("Meeting Name"));
            displayPanel.add(eventName);
            displayPanel.add(new JLabel("Meeting Time yyyy-MM-ddThh:mm:ss"));
            displayPanel.add(eventTime);
            displayPanel.add(new JLabel("Meeting End Time yyyy-MM-ddThh:mm:ss"));
            displayPanel.add(eventEndTime);
            displayPanel.add(new JLabel("Meeting Location"));
            displayPanel.add(eventLocation);
        } else if (setup == 2) { //deadline setup
            displayPanel.add(new JLabel("Deadline Name"));
            displayPanel.add(eventName);
            displayPanel.add(new JLabel("Deadline Time yyyy-MM-ddThh:mm:ss"));
            displayPanel.add(eventTime);
        }

        //submit button
        submitButton = new JButton("Submit");
        displayPanel.add(submitButton);
        
        displayPanel.revalidate();
        displayPanel.repaint();

        //action listener for submit button
        submitButton.addActionListener(e -> {
            if (setup == 1) {
                event = eventFactory.createMeeting(eventName.getText(), LocalDateTime.parse(eventTime.getText()), LocalDateTime.parse(eventEndTime.getText()), eventLocation.getText());
            } else if (setup == 2) {
                event = eventFactory.createDeadline(eventName.getText(), LocalDateTime.parse(eventTime.getText()));
            }

            EventPanel eventPanel = new EventPanel(event);
            eventListPanel.addEventPanel(eventPanel);

            setVisible(false);
        });
    

    }
}
