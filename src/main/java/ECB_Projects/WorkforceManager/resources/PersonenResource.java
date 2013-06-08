package ECB_Projects.WorkforceManager.resources;

import ECB_Projects.WorkforceManager.Model.entities.Persoon;
import ECB_Projects.WorkforceManager.Model.entities.Beheerder;
import ECB_Projects.WorkforceManager.Model.entities.dao.personenDAO;
import com.yammer.dropwizard.auth.Auth;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/gebruikers")
@Produces(MediaType.APPLICATION_JSON)
public class PersonenResource {
	private static Logger logger;
	private final personenDAO dao;

	public PersonenResource(personenDAO dao) {
		this.dao = dao;
		logger = LoggerFactory.getLogger("PersonenResource");
	}

	@GET
	@Timed
	@Path("/get")
	public Persoon getPersoon(@Auth Persoon user, String Naam) {
		logger.info(String.format(
				"%s has requested personal  information on %s", user.getName(),
				Naam));
		return dao.findPersoonByName(Naam);
	}

	@POST
	@Timed
	@Path("/post")
	public void create(@Auth Persoon user, Persoon newuser) {
		if (user instanceof Beheerder) {
			//TODO insert add user code here!
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}

	@DELETE
	@Timed
	@Path("/delete")
	public void delete(@Auth Persoon user) {
		if (user instanceof Beheerder) {
			//TODO insert remove user code here!
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}

	@PUT
	@Timed
	@Path("/put")
	public void update(@Auth Persoon user, String Naam, Persoon updateduser) {
		if (user instanceof Beheerder) {
			//TODO insert update user code here!
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}
}