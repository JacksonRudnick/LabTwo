import java.time.LocalDateTime;

public class Deadline extends Event implements Completable {
	private boolean complete;

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

	public String toString() {
		return getName() + " - " + getDateTime() + " - " + isComplete();
	}
}
