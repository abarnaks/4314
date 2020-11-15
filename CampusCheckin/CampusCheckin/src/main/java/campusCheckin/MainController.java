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
        ModelAndView mav = new ModelAndView();
        //log.info(name);
        mav.addObject("name", name);
        List<Building> buildList = b_repository.findAll();
    	String build1 = buildList.get(0).getBuildingName();
    	String build2 = buildList.get(1).getBuildingName();
    	String build3 = buildList.get(2).getBuildingName();
    	String build4 = buildList.get(3).getBuildingName();
    	
    	mav.addObject("building1", build1);
    	mav.addObject("building2", build2);
    	mav.addObject("building3", build3);
    	mav.addObject("building4", build4);
    	mav.setViewName("welcome");
//        mav.addObject("name", name);
//        mav.addObject("studid", studid);
//        mav.addObject("em", em);
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
    	String build1 = buildList.get(0).getBuildingName();
    	String build2 = buildList.get(1).getBuildingName();
    	String build3 = buildList.get(2).getBuildingName();
    	String build4 = buildList.get(3).getBuildingName();
    	if(check == 1) {
    		mav = new ModelAndView("redirect:welcome");
    		mav.addObject("name", userName); //building1
    		mav.addObject("building1", build1);
    		mav.addObject("building2", build2);
    		mav.addObject("building3", build3);
    		mav.addObject("building4", build4);
    	} else {
    		mav = new ModelAndView("index");
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
