package campusCheckin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
	
	private final RoomRepository repository;
    private RoomModelAssembler assembler;
    
    public RoomController(RoomRepository repository, RoomModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        
    }
    
    @GetMapping("/rooms")
    public CollectionModel<EntityModel<Room>> all() {

        List<EntityModel<Room>> rooms = repository.findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(rooms, linkTo(methodOn(RoomController.class).all()).withSelfRel());
    }
    
    @PostMapping("/rooms")
    public ResponseEntity<?> newRoom(@RequestBody Room newRoom) {

        EntityModel<Room> entityModel = assembler.toModel(repository.save(newRoom));

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }

    // Single item
    @GetMapping("/room/{id}")
    EntityModel<Room> one(@PathVariable Long id) {

        Room room = repository.findById(id) //
                .orElseThrow(() -> new UserNotFoundException(id));

        return assembler.toModel(room);
    }
	
	
}
