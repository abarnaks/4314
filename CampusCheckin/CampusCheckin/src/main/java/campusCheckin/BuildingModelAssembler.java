package campusCheckin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class BuildingModelAssembler implements RepresentationModelAssembler<Building, EntityModel<Building>> {

    @Override
    public EntityModel<Building> toModel(Building Build) {
		//return EntityModel.of(room, linkTo(methodOn(RoomController.class).all()).withRel("rooms"));

        return EntityModel.of(Build, //
                linkTo(methodOn(MainController.class).one(Build.getId())).withSelfRel(), linkTo(methodOn(MainController.class).all()).withRel("buildings"));
    	
    }
}
