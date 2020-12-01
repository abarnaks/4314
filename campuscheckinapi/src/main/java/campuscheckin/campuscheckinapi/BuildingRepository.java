package campuscheckin.campuscheckinapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BuildingRepository extends MongoRepository<Building,String>{
	
}
