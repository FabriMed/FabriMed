/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import beans.util.MyUtil;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Emanuel
 */
@Named(value = "appBean")
@ApplicationScoped
public class AppBean {

    /**
     * Creates a new instance of appBean
     */
    public AppBean() {
        
    }
    
    private String getBaseUrl(){
        return MyUtil.baseUrl();
    }
}
