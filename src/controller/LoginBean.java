package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;

import entity.User;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable
{
	private User user = new User();
	private String emailBanco = user.getEmail();
	private String passwordBanco = user.getPassword();
	private String email;
	private String password;
	private String summary;

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	  public void logar() throws IOException 
	  {
		  if(email.equals(emailBanco) && password.equals(passwordBanco)) 
		    {
		    //	FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
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
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
		  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
	  }
}