package ECB_Projects.WorkforceManager.Model.Winkels;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Winkel {
	@NotEmpty
    @JsonProperty
	private String naam;
	
	@NotEmpty
    @JsonProperty
	private int id;

	public Winkel(String naam,int id) {
		super();
		this.naam = naam;
		this.id = id;
	}
	
	public Winkel(){
		//for?JSON
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
