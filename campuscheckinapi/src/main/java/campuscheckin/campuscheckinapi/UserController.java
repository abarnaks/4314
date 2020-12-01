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
@RequestMapping("/user")
public class UserController {
	private UserRepository userRepo;
	private LogRepository logRepo;
	
	UserController(UserRepository uR, LogRepository lR){
		this.userRepo = uR;
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<User> getAll(){
		
		List<User> users;
		long startTime = System.currentTimeMillis();
		try {
			users =  this.userRepo.findAll();
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/all", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/all", startTime,endTime, "F" ));
			users = null;
		}
		return users;
	}
	
	@PostMapping("/new")
	public String addUser(@RequestBody User user){
		String userId = "";
		long startTime = System.currentTimeMillis();
		try {
			this.userRepo.save(user);
			userId = user.getId();
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/new", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/new", startTime,endTime, "F" ));
		}
		return userId;
	}
	
	@PutMapping("/new")
	public void putUser(@RequestBody User user){
		this.userRepo.insert(user);
	}
	
	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable("id") String id) {
		Optional<User> user;
		long startTime = System.currentTimeMillis();
		try {
			user = this.userRepo.findById(id);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/{id}", startTime,endTime, "F" ));
			user = null;
		}
		return user;
	}
	
	@GetMapping("/name/{name}")
	public User getByName(@PathVariable("name") String name) {
		User user;
		long startTime = System.currentTimeMillis();
		try {
			user = this.userRepo.findByNameEquals(name);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/name/{name}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/name/{name}", startTime,endTime, "F" ));
			user = null;
		}
		return user;
	}
	
	
	//@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	//@CrossOrigin
	public String loginUser(@RequestBody User user){
		long startTime = System.currentTimeMillis();
		String returned ="";
		
		try {
			String name = user.getName();
			String password = user.getPassword();
			
			try {
				User checkUser = userRepo.findByNameEquals(name);
				if(checkUser.getName().equals(name) && checkUser.getPassword().equals(password)) {
					returned =  checkUser.getId();
				} 
			} catch (Exception e) {
				returned = "false";
			}
			
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/login", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/user/login", startTime,endTime, "F" ));
		}
		
		return returned;
	}
	
	
}
