package campusCheckin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
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
import java.sql.Date;
import java.text.SimpleDateFormat;
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
    
    

    @PostMapping("/users")
    public ModelAndView newUser(@RequestParam("name") String name, @RequestParam("studid") String studid, @RequestParam("em") String em, @RequestParam("pass") String pass,Model model) {
    	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    	User newUser = new User(name,studid,em,pass);
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
        
        
        
        List<Booking> bookList = bo_repository.findAll();
        
        String[] rooms = new String[10];
        
        String[] roomCap = new String[10];
        String[]currentCap = new String[10];
        int roomIndex = 0;
        int counter = 0;
        List<Room> roomList = r_repository.findAll();
        for (int i = 0; i < roomList.size(); i++) {
            if(roomList.get(i).getBuilding_id() == bID) {
            	//roomIndex = i;
            	rooms[counter] =  roomList.get(i).getRoom_name();
            	roomCap[counter] = Integer.toString(roomList.get(i).getMax_capacity());
            	counter = counter + 1;
            	for(int j= 0; j < bookList.size() ;  j++) {
            		if(bookList.get(j).getRoom_Id() == roomList.get(i).getId()) {
            			
            		}
            	}
            }
        }
        
       
//        for (int i = 0; i < bookList.size(); i++) {
//            if(bookList.get(i).g) {
//            	bID = buildList.get(i).getId();
//            }
//        }
        
        for(int i =0; i< roomList.size(); i++) {
        	
        }
        
        String[] params = {buildingName , rooms[0], rooms[1], rooms[2], rooms[3], roomCap[0],roomCap[1],roomCap[2],roomCap[3], timebooking,dateToday};
        //Logger log = LoggerFactory.getLogger(MainController.class);
        
        
        
  	  	
        RedirectView rv = new RedirectView();
        rv.setUrl("/rooms/{buildingName}");
        ModelAndView mav = new ModelAndView(rv);
        mav.addObject("params", params);
    	
        return mav;
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
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
    	int check = 0;
    	List<User> userList = u_repository.findAll();
    	for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getName().equals(userName) && userList.get(i).getPassword().equals(userPass)) {
            	check = 1;
            }
        }
    	
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
