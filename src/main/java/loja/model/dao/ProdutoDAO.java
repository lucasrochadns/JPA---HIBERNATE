package loja.model.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.criteria.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import loja.entities.Produto;

public class ProdutoDAO {

	private EntityManager entityManager;

	public ProdutoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void salvar(Produto produto) {
		this.entityManager.persist(produto);
	}

	public Produto findById(Integer id) {
		return entityManager.find(Produto.class, id);
	}

	public void update(Produto produto) {
		this.entityManager.merge(produto);
	}

	public void delete(Produto produto) {
		this.entityManager.remove(produto);
	}

	public List<Produto> findAll() {
		return this.entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}

	public List<Produto> findName(String name) {
		return this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.name = :name", Produto.class)
				.setParameter("name", name).getResultList();
	}

	public List<Produto> findCategoria(String name) {
		return this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.categoria.name = ?1", Produto.class)
				.setParameter(1, name).getResultList();
	}

	public BigDecimal buscaPrecoDoProdutoComNome(String name) {
		return this.entityManager.createQuery("SELECT p.price FROM Produto p WHERE p.name = ?1", BigDecimal.class)
				.setParameter(1, name).getSingleResult();
	}

	public List<Produto> buscarPorParametroCriteira(String name, BigDecimal price, LocalDate dataCadastro) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
		Root<Produto> from = query.from(Produto.class);
		Predicate filters = builder.and();

		if (name != null && !name.trim().isEmpty()) {
			filters = builder.and(filters, builder.equal(from.get("name"), name));
		}
		if (price != null) {
			filters = builder.and(filters, builder.equal(from.get("price"), price));

		}
		if (dataCadastro != null) {
			filters = builder.and(filters, builder.equal(from.get("dataCadastro"), dataCadastro));
		}
		query.where(filters);
		return this.entityManager.createQuery(query).getResultList();

	}

}
