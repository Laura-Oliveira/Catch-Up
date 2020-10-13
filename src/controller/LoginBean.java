package controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.eclipse.persistence.sessions.Session;

import java.io.Serializable;
import java.util.Map;

import entity.User;
import service.UserImovelService;
import service.UserService;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable
{
	private User user;
	private String email;
	private String password;
	private String summary;
	
	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	Map<String, Object> sessionMap = externalContext.getSessionMap();
	
//	FacesContext context = FacesContext.getCurrentInstance();
//	HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
	
	Query queryResult=null;
	
	@EJB
    UserService userService;
  
    @PostConstruct
    public void iniciar() {
    	user  = userService.create();
    }
	
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void logar() throws IOException 
	{
		user = userService.getUserPorEmail(email);
		if(user.getPassword().equals(password)) 
		{
			sessionMap.put("usuarioLogado", user); // Persiste usuário na sessão.
			mudarPagina();
			addMessage(summary);
		} 
	}

	  public void addMessage(String summary) 
	  {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage("Usuário logado com sucesso!", message);
	    }
      
	  public void mudarPagina() throws IOException
	  {
		  try 
		  {
			FacesContext.getCurrentInstance().getExternalContext().redirect("view/index.xhtml");
		  } 
		  catch (IOException e) 
		  {
			  FacesContext.getCurrentInstance().getExternalContext().redirect("view/error.xhtml");
		  }
	  }
}