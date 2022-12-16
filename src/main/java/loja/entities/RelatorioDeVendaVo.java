package loja.entities;

import java.time.LocalDate;

public class RelatorioDeVendaVo {
  
	private String name;
	private LocalDate data;
	private Long quantidade;
	
	public RelatorioDeVendaVo() {};
	public RelatorioDeVendaVo(String name, Long quantidade, LocalDate data) {
		this.name = name;
		this.data = data;
		this.quantidade = quantidade;
	}
	public String getName() {
		return name;
	}

	public LocalDate getData() {
		return data;
	}

	public Long getQuantidade() {
		return quantidade;
	}
	

	@Override
	public String toString() {
		return "Relatorio [name=" + name + ", data=" + data + ", quantidade=" + quantidade + "]";
	}
	
	
	
}
