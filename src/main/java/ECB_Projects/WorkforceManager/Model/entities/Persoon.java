package ECB_Projects.WorkforceManager.Model.entities;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Persoon {
	@NotEmpty
    @JsonProperty
	private String name;
	
	@NotEmpty
    @JsonProperty
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persoon(int id,String name) {
		super();
		this.name = name;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
