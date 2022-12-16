package loja.entities;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private DadosPessoais dadosPessoais;

	public Cliente() {
	}

	public Cliente(Integer id, String name, String cadastroPessoaFisica) {
		this.id = id;
		this.dadosPessoais = new DadosPessoais(name, cadastroPessoaFisica);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dadosPessoais=" + dadosPessoais + "]";
	}
 
	
	

}
