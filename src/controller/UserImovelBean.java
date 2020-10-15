package controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Imovel;
import entity.User;
import entity.UserImovel;
import service.UserImovelService;
import service.UserService;
import javax.inject.Named;

@ManagedBean
@RequestScoped
public class UserImovelBean implements Serializable {
    
	private UserImovel userImovel;

	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	
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

	public void adicionarFavorito(Imovel imovel) {		
		// Não precisa checar usuário logado, botão só deve ser acessado/apresentado com usuário na sessão.
		System.out.println("é quente");
		User user = (User) sessionMap.get("usuarioLogado");
		this.userImovel.setImovel(imovel);
		this.userImovel.setUser(user);
		this.userImovel.setTipo(2);
		
		if(this.userImovelService.isFavorito(this.userImovel)) {
	        this.userImovelService.persistence(this.userImovel);
	        this.userImovel = new UserImovel();
	        addMessage("Favoritado!");
	        this.userImovel = null;
		}
		
		// TODO remover favorito.
		addMessage("Desfavoritado!");

    }
    
    public void addMessage(String summary) {
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    
}
