import javax.swing.*;
import java.awt.*;

public class EventPanel extends JPanel {
	private Event event;
	private JButton completeButton;

	EventPanel(Event e) {
		event = e;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550, 50));

		String labelText = event.getName() + " - " + event.getDateTime();
		this.add(new Label(labelText));

		completeButton = new JButton("Complete");
		this.add(completeButton, BorderLayout.EAST);
	}

	public Event getEvent() {
		return event;
	}

	//extra function??
	public void updateUrgency() {

	}
}
