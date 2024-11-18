//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
	private Event event;
	private JButton completeButton;
	private JButton convertButton;
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

		//convert button
		convertButton = new JButton("Convert");
		//action listener for convert button
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (event instanceof Deadline) {
					event = EventConverter.convertDeadlineToMeeting((Deadline) event);
					updatePanel();
				} else if (event instanceof Meeting) {
					event = EventConverter.convertMeetingToDeadline((Meeting) event);
					updatePanel();
				}
			}
		});

		this.add(convertButton, BorderLayout.WEST);
	}

	private void updatePanel() {
		eventLabel.setText(event.toString());
		this.revalidate();
		this.repaint();
	}

	public Event getEvent() {
		return event;
	}
}
