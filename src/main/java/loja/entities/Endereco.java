package loja.entities;

public class Endereco {
  
	private String bairro;
	private String cep;
	private String logadouro;
	private String cidade;
	private String estados;
	private String pais;
	private String uf;
	
	
	public Endereco() {}
	
	public Endereco(String bairro, String cep, String logadouro, String cidade, String estados, String pais,
			String uf) {
		this.bairro = bairro;
		this.cep = cep;
		this.logadouro = logadouro;
		this.cidade = cidade;
		this.estados = estados;
		this.pais = pais;
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstados() {
		return estados;
	}
	public void setEstados(String estados) {
		this.estados = estados;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
}
