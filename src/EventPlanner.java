import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class EventPlanner {
	public static void addDefaultEvents(EventPanel events) {


	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Event Planner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(600, 300));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		EventListPanel eventListPanel = new EventListPanel(frame);

		EventPanel classPanel = new EventPanel(new Deadline("Class", new Date()));
		eventListPanel.addEventPanel(classPanel);

		Date time = new Date();
		time.setTime(time.getTime() + 1 * 60 * 60 * 1000);
		EventPanel meetingPanel = new EventPanel(new Meeting("Meeting", new Date(), time, "School"));
		eventListPanel.addEventPanel(meetingPanel);

		frame.add(eventListPanel);
		frame.revalidate();
		frame.repaint();
	}
}
