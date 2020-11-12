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
class UserController {

    private final UserRepository repository;
    private UserModelAssembler assembler;
//    private final BuildingRepository b_repository;
//    private BuildingModelAssembler b_assembler;
//    
    UserController(UserRepository repository, UserModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        
    }

    // Aggregate root

    @GetMapping("/users")
    CollectionModel<EntityModel<User>> all() {

        List<EntityModel<User>> users = repository.findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @PostMapping("/users")
    public ModelAndView newUser(@RequestParam("name") String name, @RequestParam("studid") String studid, @RequestParam("em") String em, @RequestParam("pass") String pass, @RequestParam("confirm-pass") String cpass, Model model) {
    	//Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    	
    	//TODO: check that the user doesnt exist using student ID
    	
    	User newUser = new User(name,studid,em,pass,cpass);
        EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", name);
        mav.setViewName("welcome");
        //log.info(name);
        
//        mav.addObject("name", name);
//        mav.addObject("studid", studid);
//        mav.addObject("em", em);
        return mav;
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
    }
   
    public void addUser(String name, String studid, String em ,String pass, String cpass) {
    	User newUser = new User(name,studid,em,pass, cpass);
        EntityModel<User> entityModel = assembler.toModel(repository.save(newUser));
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
    	List<User> userList = repository.findAll();
    	for (int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getName().equals(userName) && userList.get(i).getPassword().equals(userPass)) {
            	check = 1;
            }
        }
    	if(check == 1) {
    		mav = new ModelAndView("redirect:welcome");
    		mav.addObject(name, userName);
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

        User user = repository.findById(id) //
                .orElseThrow(() -> new NotFoundException("user",id));

        return assembler.toModel(user);
    }

 
}