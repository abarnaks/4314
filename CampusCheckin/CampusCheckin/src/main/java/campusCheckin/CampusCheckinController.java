package campusCheckin;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CampusCheckinController {

   
   @RequestMapping({"/", "/login"})
   public String index() {
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
     // model.addAttribute("username", username);
     // model.addAttribute("password", password);
      return "createProfile";
   }
   
   
//   @RequestMapping("/login")
//   public String login() {
//     // model.addAttribute("username", username);
//     // model.addAttribute("password", password);
//      return "homelogin";
//   }
   
//   @RequestMapping("/welcome")
//   public String available(Model model, String name,String building1,String building2,String building3,String building4, String building1_cap, String building2_cap,String building3_cap ,String building4_cap) {
//	  
//      model.addAttribute("name", name);
//      model.addAttribute("building1", building1);
//      model.addAttribute("building2", building2);
//      model.addAttribute("building3", building3);
//      model.addAttribute("building4", building4);
//      model.addAttribute("building1_cap", building1_cap);
//      model.addAttribute("building2_cap", building2_cap);
//      model.addAttribute("building3_cap", building3_cap);
//      model.addAttribute("building4_cap", building4_cap);
//	  // model.addAttribute("username", username);
//	  // model
//      return "welcome";
//   }
   
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
	  // model.addAttribute("username", username);
	  // model
      return "welcome";
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
