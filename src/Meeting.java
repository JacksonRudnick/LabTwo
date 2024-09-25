//imports
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Meeting extends Event implements Completable {
    //instance variables
    private LocalDateTime endDateTime;
	private String location;
	private boolean complete;

    //constructor
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

    //in minutes
	public int getDuration() {
	    long mins = ChronoUnit.MINUTES.between(getDateTime(), getEndDateTime());

        return (int) mins;
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
    
    //toString displays name, date, duration, location, and completion status
	public String toString() {
		return getName() + " - " + getDateTime() + " - " + getDuration() + " - " + getLocation() + " - " + isComplete();
	}
}
