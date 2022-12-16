package loja.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
