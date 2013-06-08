package ECB_Projects.boodschappenLijstje.Model.Winkels.dao;


import java.util.ArrayList;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import ECB_Projects.boodschappenLijstje.Model.Winkels.Winkel;
import ECB_Projects.boodschappenLijstje.Model.Winkels.mappers.WinkelMapper;

public interface WinkelsDAO {
	
	  @SqlUpdate("create table winkels (id int primary key, name varchar(100))")
	  void createWinkelsTable();
	  
	  @SqlQuery("select COUNT(*) from winkels")
	  int getNumberOfWinkels(@Bind("name") String name);
	  
	  @SqlQuery("select * from winkels where name = :name")
	  @RegisterMapper(WinkelMapper.class)
	  Winkel findWinkelByName(@Bind("name") String name);
	  
	  @SqlQuery("select * from winkels")
	  @RegisterMapper(WinkelMapper.class)
	  List<Winkel> getAllWinkels();
	  
	  @SqlQuery("select MAX(id) from winkels")
	  @RegisterMapper(WinkelMapper.class)
	  int GetHighestId();
	  
	  @SqlUpdate("insert into winkels (id, name) values (:id, :naam)")
	  int insert(@BindBean Winkel w) throws org.skife.jdbi.v2.exceptions.UnableToExecuteStatementException;

	  @SqlUpdate("update winkels set name = :Naam , id = :id where name = :name2")
	  int update(String name2, @BindBean Winkel w);
	  
	  @SqlQuery("DELETE from winkels where name = :name")
	  int delete(@Bind("name") String name);
}
