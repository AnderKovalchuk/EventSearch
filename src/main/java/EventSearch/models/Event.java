package EventSearch.models;


import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Event {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 255)  
	private String title;
	
	@NotNull
	private Date dates;
	
	@Size(max = 300000)
	private String description;
	
	@Size(max = 10000)
	private String shortDescription;
	
	@ManyToOne
	private City city;
	
	@ManyToOne
	private EventType type;
	
	public Event(){}
	
	public Event(String title, Date dates, String description, String shortDescription) {
		super();
		this.title = title;
		this.dates = dates;
		this.description = description;
		this.shortDescription = shortDescription;
	}

	public Event(String title, Date dates, String description, String shortDescription, City city, EventType type) {
		super();
		this.title = title;
		this.dates = dates;
		this.description = description;
		this.shortDescription = shortDescription;
		this.city = city;
		this.type = type;
	}

	/* Параметри */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDates() {
		return dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Long getId() {
		return id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	
}
