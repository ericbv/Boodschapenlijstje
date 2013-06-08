package ECB_Projects.WorkforceManager;

import org.skife.jdbi.*;
import org.skife.jdbi.v2.DBI;

import ECB_Projects.WorkforceManager.Model.Winkels.dao.WinkelsDAO;
import ECB_Projects.WorkforceManager.Model.entities.Persoon;
import ECB_Projects.WorkforceManager.Model.entities.dao.personenDAO;
import ECB_Projects.WorkforceManager.core.WorkforceManagerConfiguration;
import ECB_Projects.WorkforceManager.core.SimpleAuthenticator;
import ECB_Projects.WorkforceManager.resources.PersonenResource;
import ECB_Projects.WorkforceManager.resources.WinkelResource;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.auth.basic.BasicAuthProvider;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WorkforceManagerService extends Service<WorkforceManagerConfiguration> {
	private static Logger logger;
    public static void main(String[] args) throws Exception {
    	logger = LoggerFactory.getLogger("Service");
        new WorkforceManagerService().run(args);
    }

    @Override
    public void initialize(Bootstrap<WorkforceManagerConfiguration> bootstrap) {
        bootstrap.setName("WorkforceManager");
    }

    @Override
    public void run(WorkforceManagerConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDatabaseConfiguration(), "postgresql");
        final personenDAO pDao = jdbi.onDemand(personenDAO.class);
        final WinkelsDAO wDao = jdbi.onDemand(WinkelsDAO.class);
        environment.addResource(new PersonenResource(pDao));
        environment.addResource(new WinkelResource(wDao));
        environment.addProvider(new BasicAuthProvider<Persoon>(new SimpleAuthenticator(pDao), "SUPER SECRET STUFF"));
    }
}
