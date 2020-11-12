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
public class BuildingController {
	
	private final BuildingRepository repository;
    private BuildingModelAssembler assembler;
    
    public BuildingController(BuildingRepository repository, BuildingModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        
    }
    
    @GetMapping("/buildings")
    public CollectionModel<EntityModel<Building>> all() {

        List<EntityModel<Building>> buildings = repository.findAll()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(buildings, linkTo(methodOn(BuildingController.class).all()).withSelfRel());
    }
    
    @PostMapping("/buildings")
    public ResponseEntity<?> newBuilding(@RequestBody Building newBuilding) {

        EntityModel<Building> entityModel = assembler.toModel(repository.save(newBuilding));

        return ResponseEntity 
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
                .body(entityModel);
    }

    // Single item
    @GetMapping("/building/{id}")
    EntityModel<Building> one(@PathVariable Long id) {

        Building build = repository.findById(id) //
                .orElseThrow(() -> new NotFoundException("building",id));

        return assembler.toModel(build);
    }
    
 
}
