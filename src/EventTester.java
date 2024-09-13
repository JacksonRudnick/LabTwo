import java.util.Date;

public class EventTester {
    public static void main(String[] args) {
        Date now = new Date();
        Date later = new Date(now.getTime() + 1000);
        Meeting meeting = new Meeting("Meeting", now, later, "Room 101");
        Deadline deadline = new Deadline("Deadline", later);
        System.out.println(meeting.compareTo(deadline));
        System.out.println(meeting.getDuration());
        System.out.println(meeting.isComplete());
        System.out.println(deadline.isComplete());
        meeting.complete();
        deadline.complete();
        System.out.println(meeting.isComplete());
        System.out.println(deadline.isComplete());
    }
}
