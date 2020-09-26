package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import entity.User;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean 
{
	private User user = new User();

	  public String logar() throws IOException 
	  {
	    if(user.equals(user.getEmail()) && user.equals(user.getPassword())) 
	    {
	    	FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	    }
	    return null;
	  }

	  public User getUser() 
	  {
	    return user;
	  }

	  public void setUser(User user) 
	  {
	    this.user = user;
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