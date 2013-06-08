package ECB_Projects.WorkforceManager.core;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class WorkforceManagerConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";
    
    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();


    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }
   
    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }
}
