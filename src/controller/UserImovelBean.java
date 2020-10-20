package controller;

import java.io.Serializable;
import java.util.List;
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
public class UserImovelBean implements Serializable 
{
    
	private UserImovel userImovel;
	
    @EJB
    UserImovelService userImovelService;
    
    @PostConstruct
    public void iniciar() {
    	userImovel = userImovelService.create();
    }

	public void adicionarFavorito(Imovel imovel) {	
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		
		// Não precisa checar usuário logado, botão só deve ser acessado/apresentado com usuário na sessão.
		
		this.userImovel.setComentario("blabla");
		this.userImovel.setActive(true);
		User user = (User) sessionMap.get("usuarioLogado");
		this.userImovel.setUser(user);
		this.userImovel.setImovel(imovel);
		this.userImovel.setTipo(2);
		this.userImovelService.persistence(this.userImovel);
		
		
		this.userImovel = new UserImovel();
		this.userImovel = null;
		
//		if(this.userImovelService.isFavorito(this.userImovel)) {
//	        this.userImovelService.persistence(this.userImovel);
//	        this.userImovel = new UserImovel();
//	        this.userImovel = null;
//	        addMessage("Favoritado!");
//		}
		
		// TODO remover favorito.
		addMessage("Desfavoritado!");
    }
    
    public UserImovel getUserImovel() {
		return userImovel;
	}

	public void setUserImovel(UserImovel userImovel) {
		this.userImovel = userImovel;
	}
	
    public void addMessage(String summary) {
    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
}
