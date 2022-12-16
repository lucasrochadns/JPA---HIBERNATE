package loja.entities;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal price;
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;

	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	public ItemPedido() {}

	public ItemPedido(Integer id, Integer quantidade, Pedido pedido, Produto produto) {
		this.id = id;
		this.price = produto.getPrice();
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public BigDecimal getValor() {
		return this.price.multiply(new BigDecimal(quantidade));
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, price, produto, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(price, other.price)
				&& Objects.equals(produto, other.produto) && Objects.equals(quantidade, other.quantidade);
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", price=" + price + ", quantidade=" + quantidade + ", pedido=" + pedido
				+ ", produto=" + produto + "]";
	}
 
	
}
