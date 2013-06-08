package ECB_Projects.boodschappenLijstje.core;

import org.hibernate.validator.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
	@NotEmpty
    @JsonProperty
    private final long id;
	
	@NotEmpty
    @JsonProperty
    private final String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}