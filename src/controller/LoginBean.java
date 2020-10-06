package controller;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

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
			  mudarPagina();
			  addMessage(summary);
		    } 
		  /*  try
		  {
			  
		  }
		  catch(IOException e)
		  {
			  System.out.print("Erro " + e);
		  } */
	  }

	  public void addMessage(String summary) 
	  {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
	        FacesContext.getCurrentInstance().addMessage("Usuário logado com sucesso!", message);
	    }
      
	  public void mudarPagina()
	  {
		  try 
		  {
			FacesContext.getCurrentInstance().getExternalContext().redirect("view/index.xhtml");
		  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
	  }
}