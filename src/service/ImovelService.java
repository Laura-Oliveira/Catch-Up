package service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import entity.Imovel;

@Stateless(name = "ejb/CampingService")
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
    public boolean exist(Imovel camping) {
        TypedQuery<Imovel> query
                = entityManager.createNamedQuery(Imovel.IMOVEL_POR_NOME, classe);
        query.setParameter(1, camping.getName());
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
    
    public List<Imovel> findAll() {
		List<Imovel> imovel = null;
		//Session session = null;
		//Transaction transaction = null;
		try {
			//session = sessionFactory.openSession();
			//transaction = session.beginTransaction();
			//imovel = session.createQuery("from Imovel").getResultList();
			//transaction.commit();
		} catch (Exception e) {
			imovel = null;
			//if(transaction != null) {
			//	transaction.rollback();
			//}
		} finally {
			//ssession.close();
		}
		
		return imovel; 
	}

}