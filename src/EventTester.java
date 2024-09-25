//imports
import java.time.LocalDateTime;

public class EventTester {
	public static void testMeeting() {
        LocalDateTime date = LocalDateTime.now();       
        LocalDateTime date2 = date.plusHours(1);

		Meeting meeting = new Meeting("Class", date, date2, "MCS 219");
		System.out.println(meeting.isComplete());
		System.out.println(meeting.getDateTime());
		System.out.println(meeting.getEndDateTime());
		System.out.println(meeting.getDuration());
		System.out.println(meeting.getName());
		System.out.println(meeting.getLocation());

        date = date.plusHours(1);
        date2 = date.plusHours(1);

		meeting.complete();
		meeting.setLocation("MCS 1000");
		meeting.setName("Class 2");
		meeting.setDateTime(date);
		meeting.setEndDateTime(date2);

		System.out.println(meeting.isComplete());
		System.out.println(meeting.getDateTime());
		System.out.println(meeting.getEndDateTime());
		System.out.println(meeting.getDuration());
		System.out.println(meeting.getName());
		System.out.println(meeting.getLocation());
	}

	public static void testDeadline() {
        LocalDateTime date = LocalDateTime.now();

		Deadline deadline = new Deadline("Homework", date);

		System.out.println(deadline.isComplete());
		System.out.println(deadline.getDateTime());
		System.out.println(deadline.getName());

        date = date.plusHours(1);

		deadline.complete();
		deadline.setDateTime(date);
		deadline.setName("Homework 2");

		System.out.println(deadline.isComplete());
		System.out.println(deadline.getDateTime());
		System.out.println(deadline.getName());
	}

	public static void main(String[] args) {
		System.out.println("TEST MEETING :: ");
		testMeeting();

		System.out.println("\nTEST DEADLINE :: ");
		testDeadline();
	}
}
