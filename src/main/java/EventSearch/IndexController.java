package EventSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import EventSearch.services.EventsService;

@Controller
public class IndexController {

	@Autowired
	private EventsService eventService;
	
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("events", eventService.getForEvents());
        return "index";
    }
    
    @RequestMapping("/home")
    public String indexHome() {
        return "index";
    }
    
    @RequestMapping("/registration")
    public String registration() {
        return "register";
    }
    
	@RequestMapping(value = "/login")
	public String loginForm() {
		return "login";
	}
}