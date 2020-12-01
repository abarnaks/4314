package campuscheckin.campuscheckinapi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/room")
public class RoomController {
	private RoomRepository roomRepo;
	private LogRepository logRepo;
	
	RoomController(RoomRepository rR, LogRepository lR){
		this.roomRepo = rR;
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<Room> getAll(){
		
		List<Room> rooms;
		
		long startTime = System.currentTimeMillis();
		try {
			rooms = this.roomRepo.findAll();
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/all", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/all", startTime,endTime, "F" ));
			rooms = null;
		}
		return rooms;
	}
	
	@PostMapping("/new")
	public void addUser(@RequestBody Room room){
		this.roomRepo.save(room);
		
		long startTime = System.currentTimeMillis();
		try {
			this.roomRepo.save(room);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/new", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/new", startTime,endTime, "F" ));
			
		}
	}
	
	@PutMapping("/new")
	public void putUser(@RequestBody Room room) {
		this.roomRepo.insert(room);
	}
	
	@GetMapping("/{id}")
	public Optional<Room> getById(@PathVariable("id") String id) {
		Optional<Room> room;
		
		long startTime = System.currentTimeMillis();
		try {
			room = this.roomRepo.findById(id);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/{id}", startTime,endTime, "F" ));
			room = null;
		}
		return room;
	}
	
	//finds all rooms in a building
	@GetMapping("/findRooms/{id}")
	public List<Room> getRoomsByBuildingId(@PathVariable("id") String buildingId){
		List<Room> rooms;
		
		long startTime = System.currentTimeMillis();
		try {
			rooms = this.roomRepo.findByBuildingIdEquals(buildingId);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/findRooms/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/room/findRooms/{id}", startTime,endTime, "F" ));
			rooms = null;
		}
		return rooms;
	}
	
	
}
