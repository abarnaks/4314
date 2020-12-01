package campuscheckin.campuscheckinapi;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "log")
public class Log {
	
	@Id
	private String Id;
	private String action;
	private Long startTime;
	private Long endTime;
	private String success;
	private Long timeTaken;
	private String currentTime;
	
	
	public Log() {
		
	}
	
	public Log(String act, Long st, Long et, String ss) {
		this.action = act;
		this.startTime = st;
		this.endTime = et;
		this.success = ss;
		this.timeTaken = et - st;
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    this.currentTime = formatter.format(date);
	}
	
	public String getId() {
        return this.Id;
    }
	
	public String getAction() {
		return this.action;
	}
	
	public Long getTimeTaken() {
		return this.timeTaken;
	}
	
	public String getSuccess() {
		return this.success;
	}
	
	public String getCurrentTime() {
		return this.currentTime;
	}
	
	@Override
	public String toString() {
		return "Log{" + "log_id=" + this.Id + ", startTime='" + this.startTime + '\'' + ", endTime='" + this.endTime + '\'' + ", success='" + this.success + '\'' +  ", timeTaken='" + this.timeTaken + '\'' + '}';
	}

//    public void setId(String id) {
//        this.Id = id;
//    }
//    
//    public String getUser_Id() {
//        return this.userId;
//    }
//
//    public void setUser_Id(String id) {
//        this.userId = id;
//    }
//    
//    public String getRoom_Id() {
//        return this.roomId;
//    }
//
//    public void setRoom_Id(String id) {
//        this.roomId = id;
//    }
//    
//    public String gettimeSlot() {
//    	return this.timeslot;
//    }
//    
//    public void setTimeSlot(String time_slot) {
//    	this.timeslot = time_slot;
//    }
//    
//    public int getNumber_of_people() {
//    	return this.people;
//    }
//    
//    public void setNumber_of_people(int number_of_people) {
//    	this.people = number_of_people;
//    }
    
//    @Override
//    public boolean equals(Object o) {
//
//        if (this == o)
//            return true;
//        if (!(o instanceof Log))
//            return false;
//        Log book = (Log) o;
//        return Objects.equals(this.Id, book.Id) && Objects.equals(this.userId, book.userId) && Objects.equals(this.roomId, book.roomId)
//                && Objects.equals(this.timeslot, book.timeslot) && Objects.equals(this.people, book.people);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.Id, this.userId, this.roomId, this.timeslot, this.people);
//    }
//
//    @Override
//    public String toString() {
//        return "Booking{" + "booking_id=" + this.Id + ", user_id='" + this.userId + '\'' + ", room_id='" + this.roomId + '\'' + ", time_slot='" + this.timeslot + '\'' +  ", number_of_people='" + this.people + '\'' + '}';
//    }
	
}
