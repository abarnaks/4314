package campuscheckin.campuscheckinapi;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log,String>{
	List<Log> findByActionEquals(String action);
	
}
