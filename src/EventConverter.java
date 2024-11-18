public class EventConverter {
	public static Deadline convertMeetingToDeadline(Meeting meeting) {
		return new Deadline(meeting.getName(), meeting.getDateTime());
	}

	public static Meeting convertDeadlineToMeeting(Deadline deadline) {
		return new Meeting(deadline.getName(), deadline.getDateTime(), deadline.getDateTime().plusHours(1), "N/A");
	}
}