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

    @Override
    public boolean exist(Imovel imovel) {
        TypedQuery<Imovel> query
                = entityManager.createNamedQuery(Imovel.IMOVEL_POR_NOME, classe);
        query.setParameter(1, imovel.getName());
        return !query.getResultList().isEmpty();
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Imovel getImoveisPorNome(String nome) {
        return super.findEntity(new Object[]{nome}, Imovel.IMOVEL_POR_NOME);
    }
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getAllImoveis() {
        return super.findEntities(Imovel.ALL_IMOVEL);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelApartamento() 
    {
        return super.findEntities(Imovel.IMOVEL_APARTAMENTO);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelCasa() 
    {
        return super.findEntities(Imovel.IMOVEL_CASA);
    }
    
}