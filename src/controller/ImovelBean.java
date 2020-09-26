package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.Imovel;
import entity.User;
import service.ImovelService;
import service.UserService;


@ManagedBean(name = "imovelBean")
@RequestScoped
public class ImovelBean implements Serializable 
{
    private Imovel imovel;
    private List<Imovel> imoveis;

    @EJB
    ImovelService imovelService;

    @PostConstruct
    public void iniciar() {
        imovel = imovelService.create();
    }

    public void salvar() {
        this.imovelService.persistence(this.imovel);
        this.imovel = new Imovel();
        addMessage("Imovel cadastrado com sucesso!");
        
        this.imovel = null;

    }

    public List<Imovel> getImoveis() {
        imoveis = imovelService.getAllImoveis();
        return imoveis;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
    
}