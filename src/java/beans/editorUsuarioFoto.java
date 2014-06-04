/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

/**
 *
 * @author Emanuel
 */
@Named(value="editorUsuarioFoto")
@RequestScoped
public class editorUsuarioFoto {

    private CroppedImage croppeFoto; 
    private String imageTemp; 
    /**
     * Creates a new instance of editorUsuarioFoto
     */
    public editorUsuarioFoto() {
        this.croppeFoto = null;    
        this.imageTemp = null;
    }
    
    public void actionGuardarFoto(){    
        /*
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/usuario"); 
        String archivo = path + File.separator + this.getUsuario().getId() + ".jpg";
        try {           
            if(croppeFoto!=null){ 
                FileImageOutputStream imageOutput = new FileImageOutputStream(new File(archivo));  
                imageOutput.write(croppeFoto.getBytes(), 0, croppeFoto.getBytes().length);  
                imageOutput.close();        
            }      
            else { 
                OutputStream outStream = new FileOutputStream(new File(archivo));
                InputStream inputStream = new FileInputStream(path+ "/temp/" + this.getImageTemp());   
                byte[] buffer = new byte[6124];  
                int bulk;  
                while (true) {
                    bulk = inputStream.read(buffer);    
                    if (bulk < 0) { 
                        break;    
                    }      
                    outStream.write(buffer, 0, bulk); 
                    outStream.flush();      
                }   
                outStream.close();  
                inputStream.close();
            }        
            actionFoto();
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
                */
    } 
    
    public void uploadFile(FileUploadEvent event) {     
       try {
           String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/usuario/temp");
           String archivo = path + File.separator + event.getFile().getFileName();
           FileOutputStream fileOutputStream = new FileOutputStream(archivo); 
           byte[] buffer = new byte[6124];
           int bulk; 
           InputStream inputStream = event.getFile().getInputstream();
           while (true) { 
               bulk = inputStream.read(buffer);
               if (bulk < 0) {
                   break;         
               }         
               fileOutputStream.write(buffer, 0, bulk);
               fileOutputStream.flush(); 
           }     
           fileOutputStream.close();
           inputStream.close();
           this.setImageTemp(event.getFile().getFileName());
       } catch (IOException e) {
           e.printStackTrace(); 
           FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Error al subir el archivo"));
       } 
    } 

    public CroppedImage getCroppeFoto() {
        return croppeFoto;
    }

    public void setCroppeFoto(CroppedImage croppeFoto) {
        this.croppeFoto = croppeFoto;
    }

    public String getImageTemp() {
        return imageTemp;
    }

    public void setImageTemp(String imageTemp) {
        this.imageTemp = imageTemp;
    }
   
   
}
