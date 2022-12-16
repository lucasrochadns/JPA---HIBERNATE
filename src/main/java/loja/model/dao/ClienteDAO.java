package loja.model.dao;

import javax.persistence.EntityManager;

import loja.entities.Cliente;

public class ClienteDAO {
	private EntityManager entityManager;
	
	public ClienteDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	public Cliente findById(Integer id) {
        return entityManager.find(Cliente.class, id);
	}
	
	public void update(Cliente cliente) {
		this.entityManager.merge(cliente);
	}
	public void delete(Cliente cliente) {
		this.entityManager.remove(cliente);
	}
}
