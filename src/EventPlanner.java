//imports
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {
	//add default events
    public static void addDefaultEvents(EventListPanel eventListPanel) {
		LocalDateTime time = LocalDateTime.now();
		EventPanel classPanel = new EventPanel(new Deadline("Class", time));
		eventListPanel.addEventPanel(classPanel);

		EventPanel meetingPanel = new EventPanel(new Meeting("Meeting", time.plusHours(1), time.plusHours(2), "School"));
		eventListPanel.addEventPanel(meetingPanel);
	}

    //main function
	public static void main(String[] args) {
        //create frame
		JFrame frame = new JFrame("Event Planner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(700, 300));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

        //create event list panel
		EventListPanel eventListPanel = new EventListPanel(frame);
    
        //add default events
        addDefaultEvents(eventListPanel);

        //refresh display
        eventListPanel.refreshDisplay();

        //add event list panel to frame
		frame.add(eventListPanel);
		frame.revalidate();
		frame.repaint();
	}
}
