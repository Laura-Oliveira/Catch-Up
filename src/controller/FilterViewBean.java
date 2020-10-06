package controller;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import entity.Imovel;
import service.FilterService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import entity.Imovel;

@ViewScoped
public class FilterViewBean implements Serializable {
 
    private List<Imovel> cidades;
    private List<Imovel> filteredCidades;
    private ImovelBean imovel;
    private List<Imovel> imoveis;
    private FilterService filterService;
    
    @Inject
    private FilterService service;
 
    @PostConstruct
    public void init() {
        cidades = service.createCidades(10);
    }
 
    public boolean globalFilterFunction(Object filter) 
    {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) 
        {
        	imovel.setListaImoveis();
            return true;    
        }
		return false;
        
        
     /*   else if()
 
        
        Imovel imovel = (Imovel) imovel;
        return  imovel.getCidadeImovel().toLowerCase().contains(filterText)
                || imovel.getTipoImovel().toLowerCase().contains(filterText); */
    } 
 
    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
    
    public List<String> getCidades() {
        return service.getCidades();
    }
    
    public List<Imovel> setListaImoveis()
    {
		return imoveis;
    }
 
    public void setFilteredCidades(List<Imovel> filteredCidades) 
    {
        this.filteredCidades = filteredCidades;
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
    
    public void setService(FilterService service) 
    {
        this.service = service;
    }
}