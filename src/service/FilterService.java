package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import entity.Imovel;

@Named
@ApplicationScoped
public class FilterService {
     
    private final static String[] cidades;
    private Imovel imovel;
    private List<Imovel> imoveis;
    private FilterService filterService;
     
    static {
    	cidades = new String[5];
    	cidades[0] = "Cork";
    	cidades[1] = "Dublin";
    	cidades[2] = "Galway";
    	cidades[3] = "Limerick";
    	cidades[4] = "Waterford";
       
    }
     
    public List<Imovel> createCidades(int size) {
        List<Imovel> list = new ArrayList<Imovel>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Imovel());
        }
         
        return list;
    }
     
    private String getRandomCidade() {
        return cidades[(int) (Math.random() * 10)];
    }
     
    public List<String> getCidades() {
        return Arrays.asList(cidades);
    }
    
 /*   @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelApartamento() 
    {
        return super.findEntities(Imovel.IMOVEL_APARTAMENTO);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelCasa() 
    {
        return super.findEntities(Imovel.IMOVEL_CASA);
    } */
}