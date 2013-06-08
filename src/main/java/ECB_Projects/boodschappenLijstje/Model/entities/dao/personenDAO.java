package ECB_Projects.boodschappenLijstje.Model.entities.dao;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import ECB_Projects.boodschappenLijstje.Model.entities.Persoon;
import ECB_Projects.boodschappenLijstje.Model.entities.mappers.PersoonMapper;

public interface personenDAO {
	  @SqlUpdate("create table workers (id int primary key, name varchar(100),password varchar(100))")
	  void createWorkersTable();
	  
	  @SqlUpdate("create table employers (id int primary key, name varchar(100),password varchar(100))")
	  void createEmployersTable();

	  @SqlUpdate("insert into persoon (id, name) values (:id, :name)")
	  void insert(@Bind("id") int id, @Bind("name") String name);

	  @SqlQuery("select name from something where id = :id")
	  String findNameById(@Bind("id") int id);
	  
	  @SqlQuery("select password from persoon where name = :name")
	  String getUserPassword(@Bind("name") String name);
	  
	  @SqlQuery("select * from persoon where name = :name")
	  @RegisterMapper(PersoonMapper.class)
	  Persoon findPersoonByName(@Bind("name") String name);
}
