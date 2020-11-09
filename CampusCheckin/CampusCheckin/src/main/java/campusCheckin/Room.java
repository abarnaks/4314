package campusCheckin;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
	
	
	 private @Id @GeneratedValue Long room_id;
	 private String room_name;
	 private int max_capacity;
	 private int building_id;
	 
	 
	 Room() {
		 
	 }
	 
	 Room(String room_name, int max_capacity, int building_id) {

	        this.room_name = room_name;
	        this.max_capacity = max_capacity;
	        this.building_id = building_id;
	 }
	 
	 public String room_name() {
	        return this.room_name;
	    }

	    public void room_name(String name) {
	    	 this.room_name = name;
	    }

	    public Long getId() {
	        return this.room_id;
	    }

	    public void setId(Long id) {
	        this.room_id = id;
	    }

	    public int max_capacity() {
	        return this.max_capacity;
	    }
	    
	    public void setMax_capacity(int newMax) {
	        this.max_capacity = newMax;
	    }

	   
	    public int getBuilding_id() {
	        return this.building_id;
	    }

	    public void setBuilding_id(int id) {
	        this.building_id = id;
	    }


	    @Override
	    public boolean equals(Object o) {

	        if (this == o)
	            return true;
	        if (!(o instanceof User))
	            return false;
	        Room room = (Room) o;
	        return Objects.equals(this.room_id, room.room_id) && Objects.equals(this.room_name, room.room_name) && Objects.equals(this.max_capacity, room.max_capacity)
	                && Objects.equals(this.building_id, room.building_id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.room_id, this.room_name, this.max_capacity, this.building_id);
	    }

	    @Override
	    public String toString() {
	        return "Room{" + "room_id=" + this.room_id + ", room_name='" + this.room_name + '\'' + ", max_capacity='" + this.max_capacity + '\'' + ", building_id='" + this.building_id + '\'' + '}';
	    }
	 
	 
}
