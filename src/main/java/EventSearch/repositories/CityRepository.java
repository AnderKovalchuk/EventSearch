package EventSearch.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import EventSearch.models.City;

public interface CityRepository extends CrudRepository<City, Long>{
	City findOne(Long id);
	List<City> findAll();
	
	City findByName(String name);
}
