import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {
	private LocalDateTime endDateTime;
	private String location;
	private boolean complete;

	public Meeting(String name, LocalDateTime startDateTime, LocalDateTime endDateTime, String location) {
		super(name, startDateTime);
		this.endDateTime = endDateTime;
		this.location = location;
	}

	public void complete() {
		complete = true;
	}

	public boolean isComplete() {
		return complete;
	}

	public LocalDateTime getEndDateTime() {
		return endDateTime;
	}

	//returns minutes
	public int getDuration() {
		return ((endDateTime.getHour()*60 - getDateTime().getHour()*60) + (endDateTime.getMinute() - getDateTime().getMinute()));
	}

	public String getLocation() {
		return location;
	}

	public void setEndDateTime(LocalDateTime endDateTime) {
		this.endDateTime = endDateTime;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString() {
		return getName() + " - " + getDateTime() + " - " + getDuration() + " - " + getEndDateTime() + " - " + getLocation() + " - " + isComplete();
	}
}
