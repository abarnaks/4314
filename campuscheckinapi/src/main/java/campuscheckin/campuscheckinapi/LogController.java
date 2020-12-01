package campuscheckin.campuscheckinapi;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {
	private LogRepository logRepo;
	
	LogController(LogRepository lR){
		this.logRepo = lR;
	}
	
	@GetMapping("/all")
	public List<Log> getAll(){
		
		List<Log> logs = this.logRepo.findAll();
		
		return logs;
	}
	
	@GetMapping("/{action}")
	public List<Log> getLogsByAction(@PathVariable("action") String action){
		
		List<Log> logs = this.logRepo.findByActionEquals(action);
		
		return logs;
	}
	
	
	
	
}
