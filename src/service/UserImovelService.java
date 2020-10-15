package service;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import controller.UserImovelBean;
import entity.Imovel;
import entity.User;
import entity.UserImovel;

@Stateless(name = "ejb/UserImovelService")
@LocalBean
public class UserImovelService extends Service<UserImovel> {
    
	@PostConstruct
    public void init() {
        super.setClasse(UserImovel.class);
    }

    @Override
    public UserImovel create() {
        return new UserImovel();
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
