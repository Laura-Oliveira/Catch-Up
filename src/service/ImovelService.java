package service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import entity.Imovel;
import entity.User;

@Stateless(name = "ejb/ImovelService")
@LocalBean
public class ImovelService extends Service<Imovel> {

	//private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
    @PostConstruct
    public void init() {
        super.setClasse(Imovel.class);
    }

    @Override
    public Imovel create() {
        return new Imovel();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getAllImoveis() {
        return super.findEntities(Imovel.ALL_IMOVEL);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelByTipoImovel(String tipoImovel) 
    {
        return super.findEntities(new Object[]{tipoImovel}, Imovel.TIPO_IMOVEL);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelByCidade(String cidade) 
    {
        return super.findEntities(new Object[]{cidade}, Imovel.CIDADES);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelByTipoAndCidade(String tipoImovel, String cidade) 
    {
        return super.findEntities(new Object[]{tipoImovel, cidade}, Imovel.TIPOIMOVEL_CIDADE);
    }
    
}