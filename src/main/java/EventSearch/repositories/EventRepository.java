package EventSearch.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EventSearch.models.City;
import EventSearch.models.Event;
import EventSearch.models.EventType;

public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAllByOrderByDatesDesc();
	List<Event> findAll();
	
	List<Event> findByCity(City city);
	List<Event> findByType(EventType type);
	List<Event> findByCityAndType(City city, EventType type);
	
	Event findById(Long id);
	
	
	//List<Event> findByEventType(Set<EventType> eventType);
	//List<Event> findFirst4OrderByDates();
	
}