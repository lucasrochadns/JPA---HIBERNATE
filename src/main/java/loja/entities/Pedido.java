package loja.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal valorTotal;
	private LocalDate data = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<>();
	
	public Pedido() {}
	
	public Pedido(Integer id, LocalDate data, Cliente cliente) {
		this.id = id;
		this.valorTotal = BigDecimal.ZERO;
		this.data = data;
		this.cliente = cliente;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	public List<ItemPedido> getItens(){
		return this.itens;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, data, valorTotal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(data, other.data)
				&& Objects.equals(valorTotal, other.valorTotal);
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", data=" + data + ", cliente=" + cliente + "]";
	}
}
