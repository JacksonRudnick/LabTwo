import java.util.Date;

public class EventTester {
	public static void testMeeting() {
		Date date = new Date();
		date.setHours(date.getHours() + 1);
		Date date2 = new Date(date.getTime());
		date2.setHours(date2.getHours() + 1);

		Meeting meeting = new Meeting("Class", date, date2, "MCS 219");
		System.out.println(meeting.isComplete());
		System.out.println(meeting.getDateTime());
		System.out.println(meeting.getEndDateTime());
		System.out.println(meeting.getDuration()/60000);
		System.out.println(meeting.getName());
		System.out.println(meeting.getLocation());

		date.setHours(date.getHours() + 1);
		date2.setHours(date.getHours() + 2);

		meeting.complete();
		meeting.setLocation("MCS 1000");
		meeting.setName("Class 2");
		meeting.setDateTime(date);
		meeting.setEndDateTime(date2);

		System.out.println(meeting.isComplete());
		System.out.println(meeting.getDateTime());
		System.out.println(meeting.getEndDateTime());
		System.out.println(meeting.getDuration()/60000);
		System.out.println(meeting.getName());
		System.out.println(meeting.getLocation());
	}

	public static void testDeadline() {
		Date date = new Date();
		date.setHours(date.getHours() + 1);

		Deadline deadline = new Deadline("Homework", date);

		System.out.println(deadline.isComplete());
		System.out.println(deadline.getDateTime());
		System.out.println(deadline.getName());

		date.setHours(date.getHours() + 1);

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
