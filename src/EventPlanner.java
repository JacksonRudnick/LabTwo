import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class EventPlanner {
	public static void addDefaultEvents(EventListPanel eventListPanel) {
		LocalDateTime time = LocalDateTime.now();
		EventPanel classPanel = new EventPanel(new Deadline("Class", time));
		eventListPanel.addEventPanel(classPanel);

		EventPanel meetingPanel = new EventPanel(new Meeting("Meeting", time, time.plusHours(2), "School"));
		eventListPanel.addEventPanel(meetingPanel);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Event Planner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 300));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		EventListPanel eventListPanel = new EventListPanel(frame);
    
        addDefaultEvents(eventListPanel);

		frame.add(eventListPanel);
		frame.revalidate();
		frame.repaint();
	}
}
