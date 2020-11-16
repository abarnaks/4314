package campusCheckin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;    


@RestController
public class MainController {

	private final UserRepository u_repository;
    private UserModelAssembler u_assembler;
    private final RoomRepository r_repository;
    private RoomModelAssembler r_assembler;
    private final BookingRepository bo_repository;
    private BookingModelAssembler bo_assembler;
    private final BuildingRepository b_repository;
    private BuildingModelAssembler b_assembler;
    
    public String currentBuilding;
    public String currentRoom;
    public String currentTime_slot;
    public Long userID;
	private String userName;
    
    
    
    MainController(UserRepository u_repository, UserModelAssembler u_assembler,RoomRepository r_repository, RoomModelAssembler r_assembler, BookingRepository bo_repository, BookingModelAssembler bo_assembler,BuildingRepository b_repository, BuildingModelAssembler b_assembler) {
    	this.u_repository = u_repository;
    	this.u_assembler = u_assembler;
    	this.r_repository = r_repository;
    	this.r_assembler = r_assembler;
    	this.bo_repository = bo_repository;
    	this.bo_assembler = bo_assembler;
    	this.b_repository = b_repository;
    	this.b_assembler = b_assembler;
    	
    }
    
    
    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> users = u_repository.findAll()
                .stream()
                .map(u_assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(MainController.class).all()).withSelfRel());
    }
    
//    @GetMapping("/bookings")
//    public CollectionModel<EntityModel<Booking>> getBookings() {
//
//        List<EntityModel<Booking>> books = bo_repository.findAll()
//                .stream()
//                .map(bo_assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(books, linkTo(methodOn(MainController.class).all()).withSelfRel());
//    }
    
    
    @GetMapping("/goBackHome")
    public ModelAndView returnHome() {
    	
        
        List<Building> buildList = b_repository.findAll();
        
        RedirectView rv = new RedirectView();
        rv.setUrl("welcome");
        ModelAndView mav = new ModelAndView(rv);
        //log.info(name);
        //mav.addObject("name", name);
    	String build1 = buildList.get(0).getBuildingName();
    	String build2 = buildList.get(1).getBuildingName();
    	String build3 = buildList.get(2).getBuildingName();
    	String build4 = buildList.get(3).getBuildingName();
    	String build1Cap = Integer.toString(buildList.get(0).getMax_capacity());  
    	String build2Cap = Integer.toString(buildList.get(1).getMax_capacity());  
    	String build3Cap = Integer.toString(buildList.get(2).getMax_capacity());  
    	String build4Cap = Integer.toString(buildList.get(3).getMax_capacity());  
    	
    	String[] params = {this.userName, build1, build2, build3, build4, build1Cap,build2Cap, build3Cap, build4Cap};
    	mav.addObject("params", params);
        return mav;
    }
    
    
    
    @PostMapping("/confirmbooking/{roomName}")
    public ModelAndView confirmBooking(@PathVariable String roomName,@RequestParam("study_size") String study_size, Model model) {
    	
    	Long roomID = null;
    	List<Room> roomList = r_repository.findAll();
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getRoom_name().equals(roomName)) {
            	//roomIndex = i;
            	//rooms[counter] =  roomList.get(i).getRoom_name();
            	roomID = roomList.get(i).getId();
            	//counter = counter + 1;
            	
            }
        }
    	
        int groupS = Integer.parseInt(study_size);
    	
    	Booking newBook = new  Booking(this.userID,roomID,this.currentTime_slot,groupS );
    	
    	EntityModel<Booking> entityModel = bo_assembler.toModel(bo_repository.save(newBook));
  
    	 String[] params = {roomName , this.currentBuilding, this.currentTime_slot, study_size};
        //String[] params = {roomName, this.currentBuilding, this.currentTime_slot};
   	  	
         RedirectView rv = new RedirectView();
         rv.setUrl("/confirmation");
         ModelAndView mav = new ModelAndView(rv);
         mav.addObject("params", params);
    	
    	return mav;
    }

    @PostMapping("/users")
    public ModelAndView newUser(@RequestParam("name") String name, @RequestParam("studid") String studid, @RequestParam("em") String em, @RequestParam("pass") String pass,Model model) {
    	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    	User newUser = new User(name,studid,em,pass);
    	this.userID = newUser.getId();
    	this.userName = name;
        EntityModel<User> entityModel = u_assembler.toModel(u_repository.save(newUser));
        
        List<Building> buildList = b_repository.findAll();
        
        RedirectView rv = new RedirectView();
        rv.setUrl("welcome");
        ModelAndView mav = new ModelAndView(rv);
        //log.info(name);
        //mav.addObject("name", name);
    	String build1 = buildList.get(0).getBuildingName();
    	String build2 = buildList.get(1).getBuildingName();
    	String build3 = buildList.get(2).getBuildingName();
    	String build4 = buildList.get(3).getBuildingName();
    	String build1Cap = Integer.toString(buildList.get(0).getMax_capacity());  
    	String build2Cap = Integer.toString(buildList.get(1).getMax_capacity());  
    	String build3Cap = Integer.toString(buildList.get(2).getMax_capacity());  
    	String build4Cap = Integer.toString(buildList.get(3).getMax_capacity());  
    	
    	String[] params = {name, build1, build2, build3, build4, build1Cap,build2Cap, build3Cap, build4Cap};
    	mav.addObject("params", params);
        return mav;
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
    }
    @GetMapping("prebookroom/{roomName}")
    public ModelAndView prebookingRoom(@PathVariable String roomName) {
    	
    	 
    	String[] rooms = new String[10];
    	List<Booking> bookList = bo_repository.findAll();
       
        String currentCap = null;
        int roomIndex = 0;
        int counter = 0;
        int bcounter= 0;
        String roomCap = null;
        List<Room> roomList = r_repository.findAll();
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getRoom_name().equals(roomName)) {
            	//roomIndex = i;
            	//rooms[counter] =  roomList.get(i).getRoom_name();
            	roomCap = Integer.toString(roomList.get(i).getMax_capacity());
            	//counter = counter + 1;
            	for(int j= 0; j < bookList.size() ;  j++) {
            		if(bookList.get(j).getRoom_Id() == roomList.get(i).getId() && bookList.get(j).gettimeSlot().equals(this.currentTime_slot)) {
            			 currentCap = Integer.toString(bookList.get(j).getNumber_of_people());
            			 bcounter += 1;
            		}
            	}
            }
        }
        
        if(currentCap == null) {
        	currentCap = "0";
        }
    	
    	String[] params = {roomName , this.currentBuilding, this.currentTime_slot, currentCap, roomCap};
        //String[] params = {roomName, this.currentBuilding, this.currentTime_slot};
   	  	
         RedirectView rv = new RedirectView();
         rv.setUrl("/booking/{roomName}");
         ModelAndView mav = new ModelAndView(rv);
         mav.addObject("params", params);
     	
         return mav;
    	
    
    };
    
    public String milToHour(String hour) {
    	 int newHour = Integer.parseInt(hour);  
         
         String period;
         if (newHour < 0 || newHour > 24)
         {
             return "";
         }
         else if (newHour > 12)
         {
        	 newHour = newHour - 12;
             period = "pm";
         }
         else
         {
             period = "am";
         }
         if (newHour == 0)
         {
        	 newHour = 12;
         }
         
         String ordTime = newHour +" " + period;
         return ordTime;
    	
    }
    
    
    
    @PostMapping("getroom/{buildingName}")
    public ModelAndView updateBooking(@PathVariable String buildingName,@RequestParam("date") String date,  @RequestParam("time_slot") String time_slot, @RequestParam("study_size") String study_size ) throws ParseException {
    	String bname= buildingName;
    	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    	Long bID = null;
        List<Building> buildList = b_repository.findAll();
        for (int i = 0; i < buildList.size(); i++) {
            if(buildList.get(i).getBuildingName().equals(bname)) {
            	bID = buildList.get(i).getId();
            }
        }
        
       
        
        String hours = time_slot.replace("time_", "");
        String sDate1 = date + " "+hours;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date2 = formatter.parse(date);
        
        DateFormat dateFormat = new SimpleDateFormat("MMM d");  
        String strDate = dateFormat.format(date2);  
        
        String timeOut = milToHour(hours);
        
        
        
        String timebooking = strDate + " "+hours;
        
        
        this.currentBuilding = buildingName;
        this.currentTime_slot = timebooking;
      
        
        
        List<Booking> bookList = bo_repository.findAll();
        
        String[] rooms = new String[10];
        
        String[] roomCap = new String[10];
        String[] currentCap = new String[10];
        int roomIndex = 0;
        int counter = 0;
        int bcounter= 0;
        List<Room> roomList = r_repository.findAll();
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getBuilding_id() == bID) {
            	//roomIndex = i;
            	rooms[counter] =  roomList.get(i).getRoom_name();
            	roomCap[counter] = Integer.toString(roomList.get(i).getMax_capacity());
            	counter = counter + 1;
            	for(int j= 0; j < bookList.size() ;  j++) {
            		if(bookList.get(j).getRoom_Id() == roomList.get(i).getId() && bookList.get(j).gettimeSlot().equals(timebooking)) {
            			 currentCap[bcounter] = Integer.toString(bookList.get(j).getNumber_of_people());
            			 bcounter += 1;
            		}
            	}
            }
        }
        
        for(int i =0; i < currentCap.length; i++) {
        	if(currentCap[i] == null) {
        		currentCap[i] = "0";
        	}
        }
       

        
        String[] params = {buildingName , rooms[0], rooms[1], rooms[2], rooms[3], roomCap[0],roomCap[1],roomCap[2],roomCap[3],timeOut,strDate, currentCap[0], currentCap[1], currentCap[2], currentCap[3]};
     
  	  	
        RedirectView rv = new RedirectView();
        rv.setUrl("/rooms/{buildingName}");
        ModelAndView mav = new ModelAndView(rv);
        mav.addObject("params", params);
    	
        return mav;

    }
    
    
    
    @GetMapping("getroom/{buildingName}")
    public ModelAndView goToBuilding(@PathVariable String buildingName ) {
    	String bname= buildingName;
    	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    	Long bID = null;
        List<Building> buildList = b_repository.findAll();
        for (int i = 0; i < buildList.size(); i++) {
            if(buildList.get(i).getBuildingName().equals(bname)) {
            	bID = buildList.get(i).getId();
            }
        }
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh a");  
        LocalDateTime now = LocalDateTime.now();    
        String timeToday = dtf.format(now);
        
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("EEE MMM d ");  
        LocalDateTime now1 = LocalDateTime.now();    
        String dateToday = dtf1.format(now1);
        
        
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MMM d k");  
        LocalDateTime booktime = LocalDateTime.now();    
        String timebooking = dtf2.format(booktime);
        
        this.currentBuilding = buildingName;
        this.currentTime_slot = timebooking;
        
        
        List<Booking> bookList = bo_repository.findAll();
        
        String[] rooms = new String[10];
        
        String[] roomCap = new String[10];
        String[] currentCap = new String[10];
        int roomIndex = 0;
        int counter = 0;
        int bcounter= 0;
        List<Room> roomList = r_repository.findAll();
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getBuilding_id() == bID) {
            	//roomIndex = i;
            	rooms[counter] =  roomList.get(i).getRoom_name();
            	roomCap[counter] = Integer.toString(roomList.get(i).getMax_capacity());
            	counter = counter + 1;
            	for(int j= 0; j < bookList.size() ;  j++) {
            		if(bookList.get(j).getRoom_Id() == roomList.get(i).getId() && bookList.get(j).gettimeSlot().equals(timebooking)) {
            			 currentCap[bcounter] = Integer.toString(bookList.get(j).getNumber_of_people());
            			 bcounter += 1;
            		}
            	}
            }
        }
        
        for(int i =0; i < currentCap.length; i++) {
        	if(currentCap[i] == null) {
        		currentCap[i] = "0";
        	}
        }
       

        
        String[] params = {buildingName , rooms[0], rooms[1], rooms[2], rooms[3], roomCap[0],roomCap[1],roomCap[2],roomCap[3],timebooking,dateToday, currentCap[0], currentCap[1], currentCap[2], currentCap[3]};
     
  	  	
        RedirectView rv = new RedirectView();
        rv.setUrl("/rooms/{buildingName}");
        ModelAndView mav = new ModelAndView(rv);
        mav.addObject("params", params);
    	
        return mav;

    }
    
    public void addUser(String name, String studid, String em ,String pass) {
    	User newUser = new User(name,studid,em,pass);
        EntityModel<User> entityModel = u_assembler.toModel(u_repository.save(newUser));
    }
    
//    @PostMapping("/users")
//    ResponseEntity<?> newEmployee(@RequestBody User newUser) {
//
//        EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));
//
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
//    }
    
    
//    @PostMapping("/users")
//    public RedirectView  newUser(@RequestParam("name") String name, @RequestParam("studid") String studid, @RequestParam("em") String em, @RequestParam("pass") String pass,Model model) {
//  	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//    	User newUser = new User(name,studid,em,pass);
//        EntityModel<User> entityModel = u_assembler.toModel(u_repository.save(newUser));
//        model.addAttribute("name", name);
//        RedirectView rv = new RedirectView();
//        rv.setUrl("welcome");
//		return rv;
//    
//    }
//    @PostMapping("/welcome")
//    public ModelAndView handleRequest (@RequestParam String name, Model model) {
//        model.addAttribute("name", name);
//        ModelAndView mav = new ModelAndView();
//        List<Building> buildList = b_repository.findAll();
//    	String build1 = buildList.get(0).getBuildingName();
//    	String build2 = buildList.get(1).getBuildingName();
//    	String build3 = buildList.get(2).getBuildingName();
//    	String build4 = buildList.get(3).getBuildingName();
//    	int build1Cap = buildList.get(0).getMax_capacity();
//    	int build2Cap = buildList.get(1).getMax_capacity();
//    	int build3Cap = buildList.get(2).getMax_capacity();
//    	int build4Cap = buildList.get(3).getMax_capacity();
//    	
//    	mav.addObject("building1", build1);
//    	mav.addObject("building2", build2);
//    	mav.addObject("building3", build3);
//    	mav.addObject("building4", build4);
//    	mav.addObject("building1_cap", build1Cap);
//    	mav.addObject("building2_cap", build2Cap);
//    	mav.addObject("building3_cap", build3Cap);
//    	mav.addObject("building4_cap", build4Cap);
//    	mav.setViewName("welcome");
//        return mav;
//    }
    
    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam("name") String name, @RequestParam("pass") String pass,Model model) {
    	
    	
        //EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));
    	ModelAndView mav;
    	String userName = name;
    	String userPass = pass;
    	this.userName = name;
    	Long id = null;
    	int check = 0;
    	List<User> userList = u_repository.findAll();
    	for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getName().equals(userName) && userList.get(i).getPassword().equals(userPass)) {
            	check = 1;
            	id = userList.get(i).getId();
            }
        }
    	this.userID = id;
    	List<Building> buildList = b_repository.findAll();
    	
        //log.info(name);
        //mav.addObject("name", name);
    	String build1 = buildList.get(0).getBuildingName();
    	String build2 = buildList.get(1).getBuildingName();
    	String build3 = buildList.get(2).getBuildingName();
    	String build4 = buildList.get(3).getBuildingName();
    	String build1Cap = Integer.toString(buildList.get(0).getMax_capacity());  
    	String build2Cap = Integer.toString(buildList.get(1).getMax_capacity());  
    	String build3Cap = Integer.toString(buildList.get(2).getMax_capacity());  
    	String build4Cap = Integer.toString(buildList.get(3).getMax_capacity());  
    	
    	String[] params = {userName, build1, build2, build3, build4, build1Cap,build2Cap, build3Cap, build4Cap};
    	
    	if(check == 1) {
    		RedirectView rv = new RedirectView();
            rv.setUrl("welcome");
            mav = new ModelAndView(rv);
    		mav.addObject("params", params);
    	} else {
    		//Handle wrong log in
    		RedirectView rv = new RedirectView();
            rv.setUrl("/login");
            mav = new ModelAndView(rv);
            mav.addObject("error_msg", "Invalid login, username and password don't match");
    		//mav.addObject("params", params);
    	}
        
//        mav.addObject("name", name);
//        mav.addObject("studid", studid);
//        mav.addObject("em", em);
        return mav;
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
    }
    
    // Single item
    @GetMapping("/users/{id}")
    EntityModel<User> one(@PathVariable Long id) {

        User user = u_repository.findById(id) //
                .orElseThrow(() -> new NotFoundException("user",id));

        return u_assembler.toModel(user);
    }

    
    @GetMapping("/buildings")
    public CollectionModel<EntityModel<Building>> buildAll() {

        List<EntityModel<Building>> buildings = b_repository.findAll()
                .stream()
                .map(b_assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(buildings, linkTo(methodOn(MainController.class).all()).withSelfRel());
    }
    
    @PostMapping("/buildings")
    public ResponseEntity<?> newBuilding(@RequestBody Building newBuilding) {

        EntityModel<Building> entityModel = b_assembler.toModel(b_repository.save(newBuilding));

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }

    // Single item
    @GetMapping("/building/{id}")
    EntityModel<Building> onebuild(@PathVariable Long id) {

        Building build = b_repository.findById(id) //
                .orElseThrow(() -> new NotFoundException("building",id));

        return b_assembler.toModel(build);
    }
	

	
}
