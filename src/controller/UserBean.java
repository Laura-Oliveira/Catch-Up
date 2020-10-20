package controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.User;
import service.UserService;

@ManagedBean
@RequestScoped
public class UserBean implements Serializable {

    private User usuario;

    @EJB
    UserService userService;

    @PostConstruct
    public void iniciar() {
        usuario = userService.create();
    }

    public void salvar() {
        this.userService.persistence(this.usuario);
        this.usuario = new User();
        addMessage("Usuario cadastrado com sucesso!");
        this.usuario = null;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
}