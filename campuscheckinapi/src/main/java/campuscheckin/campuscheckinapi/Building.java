package campuscheckin.campuscheckinapi;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "buildings")
public class Building {
	
	@Id
	private String id;
	private String buildingName;
    private String location;
    private int max_capacity;
    private int max_rooms;
    
	Building(){
	    	
	}
    
    Building(String buildingName, String location, int max_capacity, int max_rooms) {

        this.buildingName = buildingName;
        this.location = location;
        this.max_capacity = max_capacity;
        this.max_rooms = max_rooms;
    }
    
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getBuildingName() {
    	return this.buildingName;
    }
    
    public void setBuildingName(String buildingName) {
    	 this.buildingName = buildingName;
    }
    
    public String getlocation() {
    	return this.location;
    }
    
    public void setLocation(String location) {
    	this.location = location;
    }
    
    public int getMax_capacity() {
    	return this.max_capacity;
    }
    
    public void setMax_capacity(int max_capacity) {
    	this.max_capacity = max_capacity;
    }
    
    public int getMax_rooms() {
    	return this.max_rooms;
    }
    
    public void setMax_rooms(int max_rooms) {
    	this.max_rooms = max_rooms;
    }
    
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Building))
            return false;
        Building build = (Building) o;
        return Objects.equals(this.buildingName, build.buildingName) && Objects.equals(this.location, build.location) && Objects.equals(this.max_capacity, build.max_capacity)
                && Objects.equals(this.max_rooms, build.max_rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.buildingName, this.location, this.max_capacity, this.max_rooms);
    }

    @Override
    public String toString() {
        return "Building{" + "building_id=" + this.id + ", buildingName='" + this.buildingName + '\'' + ", location='" + this.location + '\'' + ", max_capacity='" + this.max_capacity + '\'' +  ", max_rooms='" + this.max_rooms + '\'' + '}';
    }
    
}
