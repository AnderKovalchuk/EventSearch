package EventSearch.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EventSearch.models.City;
import EventSearch.models.EventType;
import EventSearch.repositories.CityRepository;
import EventSearch.repositories.EventTypeRepository;

@Service
public class AuxiliaryService {
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private EventTypeRepository typeRepo;
	
	@Transactional
	@PostConstruct
	public void createAuxiliaryTable() {
		City city = cityRepo.findByName("Оберіть місто");
		if(city==null){
			addCity("Оберіть місто");
		}
		city = cityRepo.findByName("Вінниця");
		if(city==null){
			addCity("Вінниця");
		}
		city = cityRepo.findByName("Київ");
		if(city==null){
			addCity("Київ");
		}
		city = cityRepo.findByName("Одеса");
		if(city==null){
			addCity("Одеса");
		}
		
		EventType type = typeRepo.findByName("Оберіть напрям");
		if(type==null){
			typeRepo.save(new EventType("Оберіть напрям"));
		}
	}
	
	public List<City> getCityList(){
		return cityRepo.findAll();
	}
	
	public List<EventType> getTypeList(){
		return typeRepo.findAll();
	}
	
	public City getCityFromId(Integer id){
		return cityRepo.findOne(new Long(id));
	}
	public EventType getTypeFromId(Integer id){
		return typeRepo.findOne(new Long(id));
	}
	
	public void addCity(String name){
		cityRepo.save(new City(name));
	}
}
