package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entity.User;
import entity.UserImovel;
import service.UserImovelService;
import service.UserService;

@ManagedBean(name = "userImovelBean")
@RequestScoped
public class UserImovelBean {
    
	private UserImovel userImovel;

    @EJB
    UserImovelService userImovelService;
    
    public void add_favorito() {
        this.userImovelService.persistence(this.userImovel);
        this.userImovel = new UserImovel();
        //addMessage("UserImovel cadastrado com sucesso!");
        
        this.userImovel = null;
    }
    
}
