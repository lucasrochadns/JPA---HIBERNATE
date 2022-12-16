package loja.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Informatica extends Produto {

	private String marca;
	private String modelo;
	
	public Informatica() {}
	
	public Informatica(Integer id, String name, String descricao, BigDecimal price, LocalDate data, Categoria categoria,
			String marca, String modelo) {
		super(id, name, descricao, price, data, categoria);
		this.marca = marca;
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Informatica [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	
}
