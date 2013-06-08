package ECB_Projects.boodschappenLijstje.core;

import ECB_Projects.boodschappenLijstje.Model.entities.Persoon;
import ECB_Projects.boodschappenLijstje.Model.entities.dao.personenDAO;

import com.google.common.base.Optional;
import com.yammer.dropwizard.auth.*;
import com.yammer.dropwizard.auth.basic.BasicCredentials;

public class SimpleAuthenticator implements
		com.yammer.dropwizard.auth.Authenticator<BasicCredentials, Persoon> {
	private personenDAO dao;

	public SimpleAuthenticator(personenDAO dao) {
		super();
		this.dao = dao;
	}

	public Optional<Persoon> authenticate(BasicCredentials credentials)
			throws AuthenticationException {
		Persoon p = dao.findPersoonByName(credentials.getUsername());
		if (p != null) {
			if (dao.getUserPassword(credentials.getUsername()).equals(credentials.getPassword())) {
				return Optional.of(dao.findPersoonByName(credentials.getUsername()));
			}
		}
		return Optional.absent();
	}
}
