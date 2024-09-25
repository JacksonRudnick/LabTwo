//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
	private Event event;
	private JButton completeButton;
	private JLabel eventLabel;

    //constructor
	EventPanel(Event e) {
		event = e;

        //layout
		this.setLayout(new BorderLayout());

        //label for event
		eventLabel = new JLabel();
		eventLabel.setText(event.toString());
		this.add(eventLabel, BorderLayout.CENTER);

        //complete button
		completeButton = new JButton("Complete");
        //action listener for complete button
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
}
