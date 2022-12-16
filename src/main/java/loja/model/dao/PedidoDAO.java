package loja.model.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import loja.entities.Pedido;
import loja.entities.RelatorioDeVendaVo;

public class PedidoDAO {
	private EntityManager entityManager;
	
	public PedidoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public void salvar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}

	public Pedido findById(Integer id) {
        return entityManager.find(Pedido.class, id);
	}
	
	public void update(Pedido pedido) {
		this.entityManager.merge(pedido);
	}
	public void delete(Pedido pedido) {
		this.entityManager.remove(pedido);
	}
	
	public BigDecimal valorTotalVendido() {
		return this.entityManager.createQuery("SELECT SUM(p.valorTotal) FROM Pedido p", BigDecimal.class).getSingleResult();
	}
    
	public List<RelatorioDeVendaVo> relatorioDeVendas(){
		  String jpql = "SELECT new loja.entities.RelatorioDeVendaVo("
				    + "produto.name, "
	                + "SUM(item.quantidade) as qtd, "
	                + "MAX(pedido.data)) "
	                + "FROM Pedido pedido "
	                + "JOIN pedido.itens item "
	                + "JOIN item.produto produto "
	                + "GROUP BY produto.name "
	                + "ORDER BY qtd DESC";
		return this.entityManager.createQuery(jpql, RelatorioDeVendaVo.class).getResultList();
	}
	
	public Pedido buscarPedidoComCliente(Integer id) {
		return this.entityManager.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = ?1", Pedido.class).setParameter(1, id).getSingleResult();
	}
}
