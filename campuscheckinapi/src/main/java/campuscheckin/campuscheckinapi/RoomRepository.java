package campuscheckin.campuscheckinapi;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String>{
	Optional<Room> findById(String Id);
	List<Room> findByBuildingIdEquals(String buildId);
}
