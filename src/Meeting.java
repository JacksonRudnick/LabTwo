import java.util.Date;

public class Meeting extends Event implements Completable {
	private Date endDateTime;
	private String location;
	private boolean complete;

	public Meeting(String name, Date startDateTime, Date endDateTime, String location) {
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

	public Date getEndDateTime() {
		return endDateTime;
	}

	//in milliseconds (divide by 60000 to get minutes)
	public int getDuration() {
		return (int) (endDateTime.getTime() - getDateTime().getTime());
	}

	public String getLocation() {
		return location;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
