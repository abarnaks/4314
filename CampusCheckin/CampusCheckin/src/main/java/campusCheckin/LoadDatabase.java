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
    	Building lassonde = new Building("Lassonde", "Campus Walk", 200, 7);
    	Building bergeron = new Building("Bergeron", "Campus Walk", 250, 15); 
    	Building scottLib = new Building("Scott Library", "Campus Walk", 500, 27); 
    	Building steacieLib = new Building("Steacie Library", "Campus Walk", 350, 10); 
    	//Room lectureHallC = new Room("Lecture Hall C", 20, lassonde.getId() );
//    	Room sandbox = new Room("Sandbox" , 10 ,bergeron.getId() );
//    	Room studyRoomA = new Room("Study Room A", 5 , scottLib.getId());
//    	Room studyRoomB_SC = new Room("Study Room B", 5 , steacieLib.getId());
        return args -> {
//            log.info("Preloading " + userRepository.save(new User("Bilbo", "Baggins", "burglar")));
//            log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "thief")));
            
            //userRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));
        	log.info("Preloading " + buildingRepository.save(lassonde));
        	log.info("Preloading " + buildingRepository.save(bergeron));
        	log.info("Preloading " + buildingRepository.save(scottLib));
        	log.info("Preloading " + buildingRepository.save(steacieLib));
            log.info("Preloading " + roomRepository.save( new Room("Lecture Hall C", 20, lassonde.getId())));
            log.info("Preloading " + roomRepository.save( new Room("Lecture Hall A" , 10 ,lassonde.getId() )));
            log.info("Preloading " + roomRepository.save(new Room("Leture Hall B", 5 , lassonde.getId())));
            log.info("Preloading " + roomRepository.save(new Room("EECS Lounge", 5 , lassonde.getId())));
            //log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "thief")));
            
          //  log.info("testing" + roomRepository.findAll());
            roomRepository.findAll().forEach(room -> {
                log.info("Preloaded " + room);
              });
        };
    }
}