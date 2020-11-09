package campusCheckin;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Booking {
	private @Id @GeneratedValue Long booking_id;
    private Long user_id ;
    private Long room_id;
    private String time_slot;
    private int number_of_people;
    
    Booking(){
    	
    }
    
    Booking(Long user_id, Long room_id, String time_slot , int num_of_people ){
    	this.user_id = user_id;
    	this.room_id = room_id;
    	this.time_slot = time_slot;
    	this.number_of_people = num_of_people;
    }
    
    public Long getId() {
        return this.booking_id;
    }

    public void setId(Long id) {
        this.booking_id = id;
    }
    
    public Long getUser_Id() {
        return this.user_id;
    }

    public void setUser_Id(Long id) {
        this.user_id = id;
    }
    
    public Long getRoom_Id() {
        return this.room_id;
    }

    public void setRoom_Id(Long id) {
        this.room_id = id;
    }
    
    public String gettimeSlot() {
    	return this.time_slot;
    }
    
    public void setTimeSlot(String time_slot) {
    	this.time_slot = time_slot;
    }
    
    public int getNumber_of_people() {
    	return this.number_of_people;
    }
    
    public void setNumber_of_people(int number_of_people) {
    	this.number_of_people = number_of_people;
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Booking))
            return false;
        Booking book = (Booking) o;
        return Objects.equals(this.booking_id, book.booking_id) && Objects.equals(this.user_id, book.user_id) && Objects.equals(this.room_id, book.room_id)
                && Objects.equals(this.time_slot, book.time_slot) && Objects.equals(this.number_of_people, book.number_of_people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.booking_id, this.user_id, this.room_id, this.time_slot, this.number_of_people);
    }

    @Override
    public String toString() {
        return "Building{" + "booking_id=" + this.booking_id + ", user_id='" + this.user_id + '\'' + ", room_id='" + this.room_id + '\'' + ", time_slot='" + this.time_slot + '\'' +  ", number_of_people='" + this.number_of_people + '\'' + '}';
    }
    
    
}
