import java.util.Date;

public abstract class Event implements Comparable<Event> {
	private String name;
	private Date dateTime;

	public Event(String name, Date dateTime) {
		this.name = name;
		this.dateTime = dateTime;
	}

	public String getName() {
		return name;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Event e) {
		return dateTime.compareTo(e.getDateTime());
	}

	public abstract void complete();

	public String toString() {
		return getName() + " - " + getDateTime();
	}
}
