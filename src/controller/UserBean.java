package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.User;
import service.UserService;


@ManagedBean(name = "userBean")
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
    
    public User findUser(String cpf){
        return usuario = userService.getUserPorCPF(cpf);
    }
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
}