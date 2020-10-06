package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.User;
import entity.UserImovel;
import service.UserImovelService;
import service.UserService;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;


@ManagedBean
@RequestScoped
public class UserImovelBean implements Serializable {
    
	private UserImovel userImovel;

    @EJB
    UserImovelService userImovelService;
    
    @PostConstruct
    public void iniciar() {
    	userImovel = userImovelService.create();
    }
    
    public UserImovel getUserImovel() {
		return userImovel;
	}

	public void setUserImovel(UserImovel userImovel) {
		this.userImovel = userImovel;
	}

	public void addFavorite() {
//    	addMessage("Alô.");
    	throw new RuntimeException("Teste de exeção");
    	
//        this.userImovelService.persistence(this.userImovel);
//        this.userImovel = new UserImovel();
//        //addMessage("UserImovel cadastrado com sucesso!");
//        
//        this.userImovel = null;
    }
    
    public void addMessage(String summary) {
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    
}
