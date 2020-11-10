package campusCheckin;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class BookingModelAssembler implements RepresentationModelAssembler<Booking, EntityModel<Booking>> {
	
	@Override
    public EntityModel<Booking> toModel(Booking book) {
		//return EntityModel.of(room, linkTo(methodOn(RoomController.class).all()).withRel("rooms"));

        return EntityModel.of(book, //
                linkTo(methodOn(BookingController.class).one(book.getId())).withSelfRel(), linkTo(methodOn(BookingController.class).all()).withRel("booking"));
    	
    }
}
