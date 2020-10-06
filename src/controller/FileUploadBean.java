package controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class FileUploadBean 
{
    private UploadedFile file;
    private UploadedFile files;
 
    public UploadedFile getFile() 
    {
        return file;
    }
 
    public void setFile(UploadedFile file) 
    {
        this.file = file;
    }
 
    public UploadedFile getFiles() 
    {
        return files;
    }
 
    public void setFiles(UploadedFile files) 
    {
        this.files = files;
    }
 
    public void upload() 
    {
        if (file != null) 
        {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
     
 /*   public void uploadMultiple() 
    {
        if (files != null) 
        {
            for (UploadedFile f : file.getFileName()) 
            {
                FacesMessage message = new FacesMessage("Successful", f.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
    } */
     
    public void handleFileUpload(FileUploadEvent event) 
    {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}