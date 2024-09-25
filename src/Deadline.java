//imports
import java.time.LocalDateTime;

//deadline class
public class Deadline extends Event implements Completable {
	private boolean complete;

    //constructor
	public Deadline(String name, LocalDateTime dateTime) {
		super(name, dateTime);
		complete = false;
	}

	public void complete() {
		complete = true;
	}

	public boolean isComplete() {
		return complete;
	}

    //toString displays name, date, and completion status
	public String toString() {
		return getName() + " - " + getDateTime() + " - " + isComplete();
	}
}
