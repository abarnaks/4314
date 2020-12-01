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
@RequestMapping("/building")
public class BuildingController {
	private BuildingRepository buildRepo;
	private LogRepository logRepo;
	
	
	BuildingController(BuildingRepository bR, LogRepository lR){
		this.buildRepo = bR;
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<Building> getAll(){
		
		List<Building> build;
		long startTime = System.currentTimeMillis();
		try {
			build = this.buildRepo.findAll();
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/all", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/all", startTime,endTime, "F" ));
			build = null;
		}
		
		return build;
	}
	
	@PostMapping("/new")
	public void addUser(@RequestBody Building build){
		this.buildRepo.save(build);
		
		long startTime = System.currentTimeMillis();
		try {
			this.buildRepo.save(build);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/new", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/new", startTime,endTime, "F" ));
			
		}
	}
	
	@PutMapping("/new")
	public void putUser(@RequestBody Building build){
		this.buildRepo.insert(build);
	}
	
	@GetMapping("/{id}")
	public Optional<Building> getById(@PathVariable("id") String id) {
		Optional<Building> build;
		long startTime = System.currentTimeMillis();
		try {
			build = this.buildRepo.findById(id);
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/{id}", startTime,endTime, "S" ));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			logRepo.save(new Log("/building/{id}", startTime,endTime, "F" ));
			build = null;
		}
		return build;
	}
	
	
}
