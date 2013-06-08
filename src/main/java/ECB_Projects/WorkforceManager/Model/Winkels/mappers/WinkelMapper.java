package ECB_Projects.WorkforceManager.Model.Winkels.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import ECB_Projects.WorkforceManager.Model.Winkels.Winkel;

public class WinkelMapper implements ResultSetMapper<Winkel> {

	@Override
	public Winkel map(int index, ResultSet r, StatementContext ctx)
			throws SQLException {
		return new Winkel(r.getString("name"), r.getInt("id"));
	}

}
