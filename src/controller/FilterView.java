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

@Named("dtFilterView")
@ViewScoped
public class FilterView implements Serializable {
 
    private List<Imovel> cidades;
 
    private List<Imovel> filteredCidades;
 
    @Inject
    private FilterService service;
 
    @PostConstruct
    public void init() {
        cidades = service.createCidades(10);
    }
 
  /*  public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
 
        Imovel imovel = (Imovel) value;
        return imovel.getId().toLowerCase().contains(filterText)
                || imovel.getBrand().toLowerCase().contains(filterText)
                || imovel.getColor().toLowerCase().contains(filterText)
                || (imovel.isSold() ? "sold" : "sale").contains(filterText)
                || imovel.getYear() < filterInt
                || imovel.getPrice() < filterInt;
    } */
 
    public List<String> getCidades() {
        return service.getCidades();
    }
 
    public List<Imovel> getCidades1() {
        return cidades;
    }
 
    public void setFilteredCidades(List<Imovel> filteredCidades) {
        this.filteredCidades = filteredCidades;
    }
 
    public void setService(FilterService service) {
        this.service = service;
    }
}