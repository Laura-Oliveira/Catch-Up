package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import entity.Imovel;
import entity.User;
import service.ImovelService;
import service.UserService;

@ManagedBean
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
        this.imoveis = new ArrayList<Imovel>();
    }

    public void salvar() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		User user = (User) sessionMap.get("usuarioLogado");
		this.imovel.setUser(user);
        this.imovelService.persistence(this.imovel);
        this.imovel = new Imovel();
        addMessage("Imovel cadastrado com sucesso!");
        this.imovel = null;
    }
    
    public List<Imovel> meusImoveis() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		User user = (User) sessionMap.get("usuarioLogado");
		
		return this.imoveis = imovelService.getImovelFromUser(user.getId());
    }
    
    public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public List<Imovel> getImoveis() {
		return imoveis;
	}

	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}

	public void redirectPageRegisterImovel() throws IOException
    {
    	FacesContext.getCurrentInstance().getExternalContext().redirect("registerImovel.xhtml");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public List<Imovel> getFavoritos()
    {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		User user = (User) sessionMap.get("usuarioLogado");
		return this.imovelService.getFavoritos(user);
    }
}
