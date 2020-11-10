package campusCheckin;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String action, Long id) {
        super("Could not find " + action + " " + id);
    }
}
