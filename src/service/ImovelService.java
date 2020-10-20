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
import entity.UserImovel;

@Stateless(name = "ejb/ImovelService")
@LocalBean
public class ImovelService extends Service<Imovel> {
	
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
        TypedQuery<Imovel> query = entityManager.createNamedQuery(Imovel.IMOVEL_POR_NOME, classe);
        query.setParameter(1, imovel.getName());
        return !query.getResultList().isEmpty();
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
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Imovel> getImovelByTipoFavorito(String tipoImovelFavorito) 
    {
        return super.findEntities(new Object[]{tipoImovelFavorito}, Imovel.IMOVEL_POR_FAVORITO);
    }
    
}