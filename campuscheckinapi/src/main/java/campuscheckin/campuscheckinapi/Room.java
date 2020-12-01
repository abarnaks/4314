package campuscheckin.campuscheckinapi;

import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "rooms")
public class Room {
	@Id
	private String id;
	private String room_name;
	private int max_capacity;
	private String buildingId;
	
 public Room() {
		 
	 }
	 
	 public Room(String room_name, int max_capacity, String building_id) {

	        this.room_name = room_name;
	        this.max_capacity = max_capacity;
	        this.buildingId = building_id;
	 }
	 
	 	public String getRoom_name() {
	        return this.room_name;
	    }

	    public void setRoom_name(String name) {
	    	 this.room_name = name;
	    }

	    public String getId() {
	        return this.id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public int getMax_capacity() {
	        return this.max_capacity;
	    }
	    
	    public void setMax_capacity(int newMax) {
	        this.max_capacity = newMax;
	    }

	   
	    public String getBuilding_id() {
	        return this.buildingId;
	    }

	    public void setBuilding_id(String id) {
	        this.buildingId = id;
	    }


	    @Override
	    public boolean equals(Object o) {

	        if (this == o)
	            return true;
	        if (!(o instanceof Room))
	            return false;
	        Room room = (Room) o;
	        return Objects.equals(this.id, room.id) && Objects.equals(this.room_name, room.room_name) && Objects.equals(this.max_capacity, room.max_capacity)
	                && Objects.equals(this.buildingId, room.buildingId);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(this.id, this.room_name, this.max_capacity, this.buildingId);
	    }

	    @Override
	    public String toString() {
	        return "Room{" + "room_id=" + this.id + ", room_name='" + this.room_name + '\'' + ", max_capacity='" + this.max_capacity + '\'' + ", building_id='" + this.buildingId + '\'' + '}';
	    }
}
