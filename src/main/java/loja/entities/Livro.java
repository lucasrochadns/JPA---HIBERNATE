package loja.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Livro extends Produto{

	private String author;
	private Integer numeroPaginas;
	
	
	public Livro() {}
	public Livro(Integer id, String name, String descricao, BigDecimal price, LocalDate data, Categoria categoria,
			String author, Integer numeroPaginas) {
		super(id, name, descricao, price, data, categoria);
		this.author = author;
		this.numeroPaginas = numeroPaginas;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	@Override
	public String toString() {
		return "Livro [author=" + author + ", numeroPaginas=" + numeroPaginas + "]";
	}
	
	
}
