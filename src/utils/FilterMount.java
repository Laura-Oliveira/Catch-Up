package utils;

import java.util.Arrays;
import java.util.List;

public class FilterMount {
	
	private List<String> tipoImovel;
	private List<String> cidades;
	
	public FilterMount() {
		tipoImovel = Arrays.asList("Apartamento", "Casa");
		cidades = Arrays.asList("Cork", "Dblin", "GALWAY", "Limerick", "Waterford");
	}


	public List<String> getTipoImovel() {
		return tipoImovel;
	}


	public void setTipoImovel(List<String> tipoImovel) {
		this.tipoImovel = tipoImovel;
	}


	public List<String> getCidades() {
		return cidades;
	}


	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}
	
	
	
	

}
