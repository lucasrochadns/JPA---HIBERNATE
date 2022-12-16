package loja.entities;

import javax.persistence.Embeddable;

@Embeddable
public class DadosPessoais {
  
	private String name;
	private String cpf;
	
	public DadosPessoais() {}
	
	public DadosPessoais(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public String toString() {
		return "DadosPessoais [name=" + name + ", cpf=" + cpf + "]";
	}
	
	
	
}
