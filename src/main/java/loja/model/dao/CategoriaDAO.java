package loja.model.dao;

import javax.persistence.EntityManager;

import loja.entities.Categoria;

public class CategoriaDAO {
 
	private EntityManager entityManager;
	
	public CategoriaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvar(Categoria categoria) {
		entityManager.persist(categoria);
	}
}
