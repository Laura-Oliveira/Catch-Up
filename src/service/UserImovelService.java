package service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.TypedQuery;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;

import controller.UserImovelBean;
import entity.Imovel;
import entity.User;
import entity.UserImovel;

@Stateless(name = "ejb/UserImovelService")
@LocalBean
@ValidateOnExecution(type = ExecutableType.ALL)
public class UserImovelService extends Service<UserImovel> {
    
	@PostConstruct
    public void init() {
        super.setClasse(UserImovel.class);
    }

    @Override
    public UserImovel create() {
        return new UserImovel();
    }
    
    @Override
    public boolean exist(UserImovel userImovel) {
        TypedQuery<UserImovel> query = entityManager.createNamedQuery(userImovel.USERIMOVEL_POR_ID, classe);
        query.setParameter(1, userImovel.getId());
        return !query.getResultList().isEmpty();
    }
    
	public boolean isFavorito(UserImovel userImovel) {
//        TypedQuery<UserImovel> query = entityManager.createNamedQuery(userImovel.IMOVEL_FAVORITO_POR_ID, classe);
//        query.setParameter(1, userImovel.getUser().getId());
//        query.setParameter(2, userImovel.getImovel().getId());
//		
//        // se encontrar um userImovel significa que o usuário já favoritou uma vez.
//		if(!query.getResultList().isEmpty()) {
//			return false;
//		}
//		
		return true;
    }
}
