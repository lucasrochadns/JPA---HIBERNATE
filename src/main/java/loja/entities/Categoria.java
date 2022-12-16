package loja.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_categoria")
public class Categoria {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cat")
	private Integer id;
	
	@Column(name="name_cat")
	private String name;
	
	
	public Categoria() {}
	public Categoria(Integer id, String name) {
		this.id = id;
		this.name = name;
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", name=" + name + "]";
	}
    
	
}
