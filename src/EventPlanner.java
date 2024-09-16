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

		EventListPanel eventListPanel = new EventListPanel();

		EventPanel eventPanel = new EventPanel(new Deadline("Class", new Date()));
		eventListPanel.addEventPanel(eventPanel);

		frame.add(eventListPanel);
		frame.revalidate();
		frame.repaint();
	}
}
