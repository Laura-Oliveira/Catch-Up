package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import entity.Filtro;
import entity.Imovel;
import service.ImovelService;
import utils.FilterMount;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import entity.Imovel;

@ManagedBean
@RequestScoped
public class FilterViewBean implements Serializable {
	private Filtro filtro;
	private FilterMount filterMount;
    private List<Imovel> imoveis = new ArrayList<Imovel>();
    private  Imovel imovel;
    
    @EJB
    ImovelService imovelService;
 
    @PostConstruct
    public void init() {
    	imovel = imovelService.create();
    	filtro = new Filtro();
    	filterMount = new FilterMount();
    }
    
    public List<Imovel> getImoveis() {
    	imoveis.clear();
    	if(filtro.getTipoImovel() != "n/a" && filtro.getCidade().equals("n/a")) {
    		imoveis.addAll(imovelService.getImovelByTipoImovel(filtro.getTipoImovel()));
    	}
    	if(filtro.getCidade() != "n/a" && filtro.getTipoImovel().equals("n/a")) {
    		imoveis.addAll(imovelService.getImovelByCidade(filtro.getCidade()));
    	}
    	if(filtro.getTipoImovel() != "n/a" && filtro.getCidade() != "n/a") {
    		imoveis.addAll(imovelService.getImovelByTipoAndCidade(filtro.getTipoImovel(), filtro.getCidade()));
    	}
    		
    	if(filtro.getCidade().equals("n/a") && filtro.getTipoImovel().equals("n/a")) {
    		imoveis = imovelService.getAllImoveis();
    	}
    	
        return imoveis;
    }
    

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public FilterMount getFilterMount() {
		return filterMount;
	}

	public void setFilterMount(FilterMount filterMount) {
		this.filterMount = filterMount;
	}
	
	
    
    
    
 
  /*  public List<Imovel> getImovelTipo() 
    {
        if(filterService.getImovelApartamento().equals("Apartamento"))
        {
        	return cidades;
        }
        else if(filterService.getImovelApartamento().equals("Casa"))
        {
        	return cidades;
        }
        return cidades;
    } */
    
}