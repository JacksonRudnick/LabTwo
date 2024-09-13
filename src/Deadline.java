import java.util.Date;

public class Deadline extends Event implements Completable {
	private boolean complete;

	public Deadline(String name, Date dateTime) {
		super(name, dateTime);
		complete = false;
	}

	public void complete() {
		complete = true;
	}

	public boolean isComplete() {
		return complete;
	}
}
