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
@RequestMapping("/booking")
public class BookingController {
	private BookingRepository bookRepo;
	private LogRepository logRepo;
	
	BookingController(BookingRepository uR, LogRepository lR){
		this.bookRepo = uR;
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<Booking> getAll(){
		List<Booking> users;
		long startTime = System.currentTimeMillis();
		try {
			users = this.bookRepo.findAll();
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/all", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/all", startTime,endTime, "F" ));
			users = null;
		}
		
		return users;
	}
	
	@PostMapping("/new")
	public void addUser(@RequestBody Booking book){
		long startTime = System.currentTimeMillis();
		try {
			this.bookRepo.save(book);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/new", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/new", startTime,endTime, "F" ));
		}
		
		
	}
	
	@PutMapping("/new")
	public void putUser(@RequestBody Booking book){
		this.bookRepo.insert(book);
	}
	
	@GetMapping("/{id}")
	public Optional<Booking> getById(@PathVariable("id") String id) {
		long startTime = System.currentTimeMillis();
		Optional<Booking> book;
		try {
			book = this.bookRepo.findById(id);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "F" ));
			book = null;
		}
		return book;
	}
	//finds all bookings for a user
	@GetMapping("/findBookings/{id}")
	public List<Booking> getBookingsByUserId(@PathVariable("id") String userId){
		List<Booking> bookings;
		long startTime = System.currentTimeMillis();
		try {
			bookings = this.bookRepo.findByuserIdEquals(userId);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "F" ));
			bookings = null;
		}
		
		return bookings;
	}
	
	//finds all bookings for a user
	@GetMapping("/roomBookings/{id}")
	public List<Booking> getBookingsByRoomId(@PathVariable("id") String roomId){
		List<Booking> bookings;
		
		long startTime = System.currentTimeMillis();
		try {
			bookings = this.bookRepo.findByroomIdEquals(roomId);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/booking/{id}", startTime,endTime, "F" ));
			bookings = null;
		}
		return bookings;
	}
	
}
