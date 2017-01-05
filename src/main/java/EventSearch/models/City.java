package EventSearch.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class City {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String name;

	public City(){}
	
	public City(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
