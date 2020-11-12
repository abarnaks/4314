package campusCheckin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
    
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoomRepository roomRepository, BuildingRepository buildingRepository, BookingRepository bookingRepository) {
    	Building berg = new Building("Bergeron", "Campus walk", 200,5);
        return args -> {
        	
//            log.info("Preloading " + userRepository.save(new User("Bilbo", "Baggins", "burglar")));
//            log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "thief")));
        	log.info("Preloading " + buildingRepository.save(berg));
        	log.info("Preloading " + buildingRepository.save(new Building("Lassonde", "Campus walk", 200,5)));
        	log.info("Preloading " + buildingRepository.save(new Building("Scott Library", "Campus walk", 200,5)));
        	log.info("Preloading " + buildingRepository.save(new Building("Steacie Library", "Campus walk", 200,5)));
            //userRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
            log.info("Preloading " + roomRepository.save(new Room("Sandbox", 10, berg.getId())));
            //log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "thief")));
            
          //  log.info("testing" + roomRepository.findAll());
            roomRepository.findAll().forEach(room -> {
                log.info("Preloaded " + room);
              });
        };
    }
}