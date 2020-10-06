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
	
	public boolean addFavorite(Imovel imovel, User user) {
    	UserImovel userImovel = new UserImovel();
    	
    	
        TypedQuery<UserImovel> query = entityManager.createNamedQuery(userImovel.IMOVEL_FAVORITO_POR_ID, classe);
		
        query.setParameter(1, user.getId());
        query.setParameter(2, imovel.getId());
		
        // se encontrar um userImovel significa que o usuário já favoritou uma vez.
		if(!query.getResultList().isEmpty()) {
			// TODO remover favorito
			
			return false;
		}
		
		// adicionar favorito na tabela UserImovel
		userImovel.setImovel(imovel);
		userImovel.setUser(user);
		userImovel.setTipo(2);
		
		UserImovelBean uiBean = new UserImovelBean();
//		uiBean.addFavorite();
		
		
		return true;

    }
}
