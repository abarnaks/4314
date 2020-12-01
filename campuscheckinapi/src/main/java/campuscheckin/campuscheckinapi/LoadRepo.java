package campuscheckin.campuscheckinapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadRepo implements CommandLineRunner {
	
	private UserRepository userRepo;
	private BookingRepository bookRepo;
	private RoomRepository roomRepo;
	private BuildingRepository buildRepo;
	private LogRepository logRepo;
	
	public LoadRepo(UserRepository ur, BookingRepository br, RoomRepository rR, BuildingRepository buR, LogRepository lR) {
		this.userRepo = ur;
		this.bookRepo = br;
		this.roomRepo = rR;
		this.buildRepo = buR;
		this.logRepo = lR;
	}
	
	@Override
	public void run(String...strings) throws Exception {
		User bob = new User("Bob" ,"Bob123" ,"Bob@student.com","1234"  );
		User jilly = new User("Jilly" ,"Jilly1996","Jil@student.com", "123412" );
		User rob = new User("Rob" , "Robbie" ,"Rob@student.com", "122334" );
		
		Building Lassonde = new Building("Lassonde", "Campus Walk" , 200, 10);
		Building ross = new Building("Ross Building", "Campus Walk" , 200, 10);
		
		
		//clear collection
		this.userRepo.deleteAll();
		this.bookRepo.deleteAll();
		this.roomRepo.deleteAll();
		this.buildRepo.deleteAll();
		this.logRepo.deleteAll();
		//add users
		List<User> users = Arrays.asList(bob,jilly,rob);
		
		this.userRepo.saveAll(users);
		
		List<Building> builds = Arrays.asList(Lassonde,ross);
		
		this.buildRepo.saveAll(builds);
		
		Room lasC = new Room("Lecture Hall C", 15, Lassonde.getId());
		Room lasA = new Room("Lecture Hall A", 15, Lassonde.getId());
		Room lasB = new Room("Lecture Hall B", 15, Lassonde.getId());
		Room ross122 = new Room("Ross Room 122", 15, Lassonde.getId());
		Room ross123 = new Room("Ross Room 256", 15, Lassonde.getId());
		
		List<Room> rooms = Arrays.asList(lasC,lasA,lasB,ross122,ross123);
		
		this.roomRepo.saveAll(rooms);
		
		Booking book1 = new Booking(bob.getId(),lasC.getId(),10,"10_pm");
		Booking book2 = new Booking(rob.getId(),ross122.getId(),10,"10_pm");
		
		List<Booking> books = Arrays.asList(book1,book2);
		this.bookRepo.saveAll(books);
		
		
		
	}
}
