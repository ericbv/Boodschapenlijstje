package ECB_Projects.boodschappenLijstje.Model.entities.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ECB_Projects.boodschappenLijstje.Model.entities.Beheerder;
import ECB_Projects.boodschappenLijstje.Model.entities.Gebruiker;
import ECB_Projects.boodschappenLijstje.Model.entities.Persoon;

public class PersoonMapper implements ResultSetMapper<Persoon> {

	public Persoon map(int arg0, ResultSet r, StatementContext arg2)
			throws SQLException {
			return new Persoon(r.getInt("id"), r.getString("name"));

	}

}
