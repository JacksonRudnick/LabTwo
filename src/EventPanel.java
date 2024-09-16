import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
	private Event event;
	private JButton completeButton;
	private JLabel eventLabel;

	EventPanel(Event e) {
		event = e;

		this.setLayout(new BorderLayout());

		eventLabel = new JLabel();
		eventLabel.setText(event.toString());
		this.add(eventLabel, BorderLayout.CENTER);

		completeButton = new JButton("Complete");
		completeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				event.complete();
				eventLabel.setText(event.toString());
			}
		});

		this.add(completeButton, BorderLayout.EAST);
	}

	public Event getEvent() {
		return event;
	}

	//extra function??
	public void updateUrgency() {

	}
}
