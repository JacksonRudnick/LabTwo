//imports
import java.time.LocalDateTime;

//abstract class Event
public abstract class Event implements Comparable<Event> {
	private String name;
	private LocalDateTime dateTime;

    //constructor
	public Event(String name, LocalDateTime dateTime) {
		this.name = name;
		this.dateTime = dateTime;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setName(String name) {
		this.name = name;
	}

    //compareTo method
	public int compareTo(Event e) {
		return dateTime.compareTo(e.getDateTime());
	}

    //toString displays name and date
	public String toString() {
		return getName() + " - " + getDateTime();
	}

    public abstract boolean isComplete();

	public abstract void complete();
}
