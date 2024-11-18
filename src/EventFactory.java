import java.time.LocalDateTime;

public class EventFactory {
	public Deadline createDeadline(String name, LocalDateTime dateTime) {
		return new Deadline(name, dateTime);
	}

	public Meeting createMeeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		return new Meeting(name, startDateTime, endDateTime, location);
	}
}