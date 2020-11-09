package campusCheckin;

public class RoomNotFoundException extends RuntimeException {
	
	 RoomNotFoundException(Long id) {
	        super("Could not find riin " + id);
	    }
	
}
