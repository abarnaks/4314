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
    CommandLineRunner initDatabase(UserRepository userRepository, OrderRepository orderRepository) {

        return args -> {
            log.info("Preloading " + userRepository.save(new User("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + userRepository.save(new User("Frodo", "Baggins", "thief")));
            
            userRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
              log.info("Preloaded " + order);
            });
        };
    }
}