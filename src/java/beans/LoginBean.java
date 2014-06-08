/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Emanuel
 */
@Named(value="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    public String usuaCuenta;
    public String usuaContrasena;
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsuaCuenta() {
        return usuaCuenta;
    }

    public void setUsuaCuenta(String usuaCuenta) {
        this.usuaCuenta = usuaCuenta;
    }

    public String getUsuaContrasena() {
        return usuaContrasena;
    }

    public void setUsuaContrasena(String usuaContrasena) {
        this.usuaContrasena = usuaContrasena;
    }
    
    public void login(ActionEvent actionEvent){

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;
        
        if(usuaCuenta != null && usuaCuenta.equals("admin") && usuaContrasena != null && usuaContrasena.equals("admin")){
            loggedIn= true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido",usuaCuenta);
        }else{
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login Error","Credenciales Invalidas");
        }
        FacesContext.getCurrentInstance().addMessage(null,msg);
        context.addCallbackParam("loggedIn",loggedIn);
    }
}
