package campusCheckin;

public class NotFoundException extends RuntimeException {

	NotFoundException(String action, Long id) {
        super("Could not find " + action + " " + id);
    }
}
