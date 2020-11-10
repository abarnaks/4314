package campusCheckin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampusCheckinController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }

   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, @RequestParam("studid") String studid, Model model) {
      model.addAttribute("name", name);
      model.addAttribute("studid", studid);
      return "hello";
   }
   
   @RequestMapping("/login")
   public String login() {
     // model.addAttribute("username", username);
     // model.addAttribute("password", password);
      return "homelogin";
   }
   
   @RequestMapping("/booking")
   public String book() {
      //model.addAttribute("name", name);
	  // model.addAttribute("username", username);
	  // model
      return "booking";
   }
   
   @RequestMapping("/confirmation")
   public String confirmation() {
      //model.addAttribute("name", name);
      return "confirmation";
   }
   
	@GetMapping({"/greeting"})
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
