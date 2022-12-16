package loja.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tb_produto")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Produto {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_prod")
	private Integer id;
	private String name;
	@Column(name="desc_prod")
	private String descricao;
	@Column(name="price_prod")
	private BigDecimal price;
	@Column(name="date_prod")
	private LocalDate data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	
	public Produto() {}
	
	public Produto(Integer id, String name, String descricao, BigDecimal price, LocalDate data, Categoria categoria) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.price = price;
		this.data = data;
		this.categoria = categoria;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
    
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(descricao, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", name=" + name + ", descricao=" + descricao + ", price=" + price + ", data="
				+ data + ", categoria=" + categoria + "]";
	}
	
	
	
}
