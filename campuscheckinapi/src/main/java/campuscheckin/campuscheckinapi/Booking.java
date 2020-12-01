package campuscheckin.campuscheckinapi;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {
	
	@Id
	private String Id;
	private String userId;
	private String roomId;
	private int people;
	private String timeslot;
	
	public Booking() {
		
	}
	
	public Booking(String un, String rm, int p, String ts) {
		this.userId = un;
		this.roomId = rm;
		this.people = p;
		this.timeslot = ts;
	}
	
	public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }
    
    public String getUser_Id() {
        return this.userId;
    }

    public void setUser_Id(String id) {
        this.userId = id;
    }
    
    public String getRoom_Id() {
        return this.roomId;
    }

    public void setRoom_Id(String id) {
        this.roomId = id;
    }
    
    public String gettimeSlot() {
    	return this.timeslot;
    }
    
    public void setTimeSlot(String time_slot) {
    	this.timeslot = time_slot;
    }
    
    public int getNumber_of_people() {
    	return this.people;
    }
    
    public void setNumber_of_people(int number_of_people) {
    	this.people = number_of_people;
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Booking))
            return false;
        Booking book = (Booking) o;
        return Objects.equals(this.Id, book.Id) && Objects.equals(this.userId, book.userId) && Objects.equals(this.roomId, book.roomId)
                && Objects.equals(this.timeslot, book.timeslot) && Objects.equals(this.people, book.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.Id, this.userId, this.roomId, this.timeslot, this.people);
    }

    @Override
    public String toString() {
        return "Booking{" + "booking_id=" + this.Id + ", user_id='" + this.userId + '\'' + ", room_id='" + this.roomId + '\'' + ", time_slot='" + this.timeslot + '\'' +  ", number_of_people='" + this.people + '\'' + '}';
    }
	
}
