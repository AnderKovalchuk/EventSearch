package EventSearch.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EventSearch.models.Event;
import EventSearch.repositories.CityRepository;
import EventSearch.repositories.EventRepository;
import EventSearch.repositories.EventTypeRepository;


@Service
public class EventsService {
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private EventTypeRepository typeRepo;
	
	public List<Event> getAllEvents() {
		return eventRepo.findAllByOrderByDatesDesc();
	}
	public List<Event> getForEvents(){
		List<Event> ev = eventRepo.findAll(); 
		List<Event> e = new ArrayList<Event>();
		
		for(int i = 0; i < 4; i++)
			e.add(ev.get(i));
		
		return e;
	}
	public List<Event> getListFromFilter(Integer cityId, Integer typeId){
		if(typeId == 1 && cityId == 1)
			return eventRepo.findAll();
		if(typeId == 1)
			return eventRepo.findByCity(cityRepo.findOne(new Long(cityId)));
		if(cityId == 1)
			return eventRepo.findByType(typeRepo.findOne(new Long(typeId)));
		return eventRepo.findByCityAndType(
				cityRepo.findOne(new Long(cityId)),
				typeRepo.findOne(new Long(typeId)));
	}
	
	public Event getForId(Long id){
		return eventRepo.findById(id);
	}
	
	public void addEvent(Event e, Integer cityId, Integer typeId){
		e.setCity(cityRepo.findOne(new Long(cityId)));
		e.setType(typeRepo.findOne(new Long(typeId)));
		eventRepo.save(e);
	}
}