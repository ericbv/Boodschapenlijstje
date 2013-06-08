package ECB_Projects.WorkforceManager.Model.entities.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ECB_Projects.WorkforceManager.Model.entities.Gebruiker;
import ECB_Projects.WorkforceManager.Model.entities.Persoon;
import ECB_Projects.WorkforceManager.Model.entities.Beheerder;

public class PersoonMapper implements ResultSetMapper<Persoon> {

	public Persoon map(int arg0, ResultSet r, StatementContext arg2)
			throws SQLException {
			return new Persoon(r.getInt("id"), r.getString("name"));

	}

}
