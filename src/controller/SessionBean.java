package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.User;
import service.UserService;

@ManagedBean
@RequestScoped
public class SessionBean implements Serializable {

    private User usuarioLogado;

    @EJB
    UserService userService;

    @PostConstruct
    public void iniciar() {
    	usuarioLogado = userService.create();
    }

    public boolean isLogged() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.usuarioLogado  = (User) sessionMap.get("usuarioLogado");
		return this.usuarioLogado != null;
    }
    
    public void logOut() throws IOException {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		this.usuarioLogado  = (User)sessionMap.remove("usuarioLogado");
    	FacesContext.getCurrentInstance().getExternalContext().redirect("home");
    }

    public User getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(User usuario) {
        this.usuarioLogado = usuario;
    }
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
}