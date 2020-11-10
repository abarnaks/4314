package campusCheckin;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class RoomModelAssembler implements RepresentationModelAssembler<Room, EntityModel<Room>> {

    @Override
    public EntityModel<Room> toModel(Room room) {
		//return EntityModel.of(room, linkTo(methodOn(RoomController.class).all()).withRel("rooms"));

        return EntityModel.of(room, //
                linkTo(methodOn(RoomController.class).one(room.getId())).withSelfRel(), linkTo(methodOn(RoomController.class).all()).withRel("rooms"));
    	
    }
}
