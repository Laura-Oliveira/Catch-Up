package entity;

import java.util.List;

public class Filtro {
	
	private String tipoImovel;
	private String cidade;
	private int qtdComodos;
	
	
	
	public Filtro() {
		super();
		this.tipoImovel = "n/a";
		this.cidade = "n/a";
		this.qtdComodos = 0;
	}
	public String getTipoImovel() {
		return tipoImovel;
	}
	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getQtdComodos() {
		return qtdComodos;
	}
	public void setQtdComodos(int qtdComodos) {
		this.qtdComodos = qtdComodos;
	}
	
	

}
