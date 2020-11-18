package campusCheckin;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CampusCheckinController {

   
   @RequestMapping({"/", "/login"})
   public String index(@RequestParam(name="error_msg", required=false) String error_msg, Model model) {
	  model.addAttribute("error_msg", error_msg);
      return "index";
   }
	
   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, @RequestParam("studid") String studid, @RequestParam("em") String em, Model model) {
      model.addAttribute("name", name);
      model.addAttribute("studid", studid);
      model.addAttribute("em", em);
      
      return "hello";
   }
   
   @RequestMapping("/signup")
   public String signupPage() {
      return "createProfile";
   }
   
   @RequestMapping("/booking/{roomName}")
   public String bookingPage(Model model, String[] params) {
     model.addAttribute("buildingName", params[1]);
     model.addAttribute("roomName", params[0]);
     model.addAttribute("time_slot", params[2]);
     model.addAttribute("currentCap", params[3]);
     model.addAttribute("max_cap", params[4]);
     return "booking";
   }
   
  
   @RequestMapping("/welcome")
   public String available(Model model, String[] params) {
	  
      model.addAttribute("name", params[0]);
      model.addAttribute("building1", params[1]);
      model.addAttribute("building2", params[2]);
      model.addAttribute("building3", params[3]);
      model.addAttribute("building4", params[4]);
      model.addAttribute("building1_cap", params[5]);
      model.addAttribute("building2_cap", params[6]);
      model.addAttribute("building3_cap", params[7]);
      model.addAttribute("building4_cap", params[8]);
      model.addAttribute("Booking1", params[9]);
      model.addAttribute("Booking2", params[10]);
      model.addAttribute("Booking3", params[11]);
      return "welcome";
   }
   
   @RequestMapping("rooms/{buildingName}")
   public String book(Model model, String[] params) {
	  
      
	  model.addAttribute("buildingName", params[0]);
	  model.addAttribute("Room1", params[1]);
	  model.addAttribute("Room2", params[2]);
	  model.addAttribute("Room3", params[3]);
	  model.addAttribute("Room4", params[4]);
	  model.addAttribute("Room1cap", params[5]);
	  model.addAttribute("Room2cap", params[6]);
	  model.addAttribute("Room3cap", params[7]);
	  model.addAttribute("Room4cap", params[8]);
	  model.addAttribute("time_h", params[9]);
	  model.addAttribute("date", params[10]);
	  model.addAttribute("CurrentCap1", params[11]);
	  model.addAttribute("CurrentCap2", params[12]);
	  model.addAttribute("CurrentCap3", params[13]);
	  model.addAttribute("CurrentCap4", params[14]);
	  // model
      return "rooms";
   }
   
   @RequestMapping("/confirmation")
   public String confirmation(Model model, String[] params) {
      model.addAttribute("roomName", params[0]);
      model.addAttribute("buildingName", params[1]);
      model.addAttribute("time_slot", params[2]);
      model.addAttribute("study_size", params[3]);
      return "confirmation";
   }
   
	@GetMapping({"/greeting"})
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
