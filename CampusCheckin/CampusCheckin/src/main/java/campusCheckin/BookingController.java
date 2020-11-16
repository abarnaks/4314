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
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookingController {
	private final BookingRepository repository;
    private BookingModelAssembler assembler;
    
    public BookingController(BookingRepository repository, BookingModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
        
    }
    
//    @GetMapping("/bookings")
//    public CollectionModel<EntityModel<Booking>> all() {
//
//        List<EntityModel<Booking>> books = repository.findAll()
//                .stream()
//                .map(assembler::toModel)
//                .collect(Collectors.toList());
//
//        return CollectionModel.of(books, linkTo(methodOn(RoomController.class).all()).withSelfRel());
//    }
//    
//    @GetMapping("/ShowBookings")
//    public ModelAndView showBookings() {
//    	ModelAndView mav = new ModelAndView("booking");
//    	return mav;
//    }
//    
//    @PostMapping("/bookings")
//    public ResponseEntity<?> newBooking(@RequestBody Booking newBooking) {
//
//        EntityModel<Booking> entityModel = assembler.toModel(repository.save(newBooking));
//
//        return ResponseEntity 
//                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) 
//                .body(entityModel);
//    }

//    // Single item
//    @GetMapping("/booking/{id}")
//    EntityModel<Booking> one(@PathVariable Long id) {
//
//        Booking book = repository.findById(id) //
//                .orElseThrow(() -> new NotFoundException("booking",id));
//
//        return assembler.toModel(book);
//    }
}
