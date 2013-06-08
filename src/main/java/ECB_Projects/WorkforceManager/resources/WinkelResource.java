package ECB_Projects.WorkforceManager.resources;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import ECB_Projects.WorkforceManager.Model.Winkels.Winkel;
import ECB_Projects.WorkforceManager.Model.Winkels.dao.WinkelsDAO;
import ECB_Projects.WorkforceManager.Model.entities.Beheerder;
import ECB_Projects.WorkforceManager.Model.entities.Persoon;

import com.yammer.dropwizard.auth.Auth;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/winkel")
@Produces(MediaType.APPLICATION_JSON)
public class WinkelResource {
	private static Logger logger;
	private final WinkelsDAO dao;

	public WinkelResource(WinkelsDAO dao) {
		this.dao = dao;
		logger = LoggerFactory.getLogger("PersonenResource");
	}

	@GET
	@Timed
	@Path("/get")
	public Winkel getWinkel(@Auth Persoon user, @QueryParam("name") String Naam) {
		logger.info(String.format(
				"%s has requested personal  information on shop %s", user.getName(),
				Naam));
		return dao.findWinkelByName(Naam);
	}
	@GET
	@Timed
	@Path("/get/id")
	public int getId(@Auth Persoon user) {
		logger.info(String.format(
				"%s has requested new ID", user.getName()));
		return dao.GetHighestId()+1;
	}
	@GET
	@Timed
	@Path("/get/all")
	public ArrayList<Winkel> getAllWinkel(@Auth Persoon user) {
		logger.info(String.format(
				"%s has requested personal  information onall shops", user.getName()));
		return (ArrayList<Winkel>) dao.getAllWinkels();
	}

	@POST
	@Timed
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(@Auth Persoon user, Winkel newstore) {
		/*if (user instanceof Beheerder) {
			dao.insert(newstore);
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}*/
		try {
			dao.insert(newstore);
			throw new WebApplicationException(Response.Status.CREATED);
		} catch (UnableToExecuteStatementException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Timed
	@Path("/delete")
	public void delete(@Auth Persoon user,@QueryParam("name") String Naam) {
		if (user instanceof Beheerder) {
			
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}

	@PUT
	@Timed
	@Path("/put")
	public void update(@Auth Persoon user, @QueryParam("name") String Naam, Winkel updateduser) {
		if (user instanceof Beheerder) {
			//TODO insert update user code here!
		} else {

			throw new WebApplicationException(Response.Status.UNAUTHORIZED);
		}
	}
	
	@GET
	@Timed
	@Path("/createbase")
	public int createbase() {
		dao.createWinkelsTable();
		throw new WebApplicationException(Response.Status.CREATED);
	}
}