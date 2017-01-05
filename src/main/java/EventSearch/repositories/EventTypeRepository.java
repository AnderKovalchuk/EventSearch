package EventSearch.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EventSearch.models.EventType;

public interface EventTypeRepository extends CrudRepository<EventType, Long>{
	EventType findOne(Long id);
	List<EventType> findAll();
	
	EventType findByName(String name);
}
