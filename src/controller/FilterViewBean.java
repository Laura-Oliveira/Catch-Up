package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import entity.Imovel;
import service.ImovelService;

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
	
	private String apartamento;
    private List<Imovel> imoveis;
    private  Imovel imovel;
    
    @EJB
    ImovelService imovelService;
 
    @PostConstruct
    public void init() {
    	imovel = imovelService.create();
    	apartamento = "";
    }
    
    public List<Imovel> getImoveis() throws IOException {
    	
    	System.out.println(apartamento);
    	
    	if(apartamento.equals("Apartamento")) {
    		imoveis = imovelService.getImovelApartamento();
            return imoveis;
    	}
    	
        imoveis = imovelService.getAllImoveis();
        return imoveis;
    }

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
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