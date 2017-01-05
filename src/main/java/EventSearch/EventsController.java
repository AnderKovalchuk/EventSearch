package EventSearch;

import java.util.Date;

import EventSearch.models.Event;
import EventSearch.services.AuxiliaryService;
import EventSearch.services.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.Date;

@Controller
public class EventsController {
	
	@Autowired
	private EventsService eventService;

	@Autowired
	private AuxiliaryService auxService;
	
    @RequestMapping("/events")
    public String index(Model model) {
    	model.addAttribute("events", eventService.getAllEvents());
    	model.addAttribute("city", auxService.getCityList());
    	model.addAttribute("type", auxService.getTypeList());
        return "events";
    }
    
    @RequestMapping("/createEvent")
    public String createEvet(Model model) {
    	model.addAttribute("city", auxService.getCityList());
    	model.addAttribute("type", auxService.getTypeList());
        return "createEvent";
    }
    
    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public String event(Model model, @RequestParam("id") Long id){
    	model.addAttribute("event", eventService.getForId(id));
    	return "event";
    }

    @RequestMapping(value = "/createEvent", method = RequestMethod.POST)
    public String createEvent(
    		@RequestParam("EventName") String name, 
    		@RequestParam("Description") String description,
    		@RequestParam("ShortDescription") String shortDescription,
    		@RequestParam("nap") Integer typeId,
    		@RequestParam("city") Integer cityId
    		) {
    	
    	eventService.addEvent(new Event(name, new Date(), description, shortDescription), cityId, typeId);
        return "redirect:events";
    }
    
    @RequestMapping(value = "/filterEvent", method = RequestMethod.POST)
    public String filterEvent(Model model,
    		@RequestParam("nap") Integer typeId,
    		@RequestParam("city") Integer cityId){
    	model.addAttribute("events", eventService.getListFromFilter(cityId, typeId));
    	model.addAttribute("city", auxService.getCityList());
    	model.addAttribute("type", auxService.getTypeList());
    	return "events";
    }
}