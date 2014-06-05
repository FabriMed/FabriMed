/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.util;

import entity.Producto;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

/**
 *
 * @author Emanuel
 */
public class MyUtil {

    public static String baseUrl(){
        return "http://localhost:8080/FabriMed";
    }
    
    public static String guardarImagenEnFicheroTemporal(byte[] bytes, String nombreArchivo){
        System.out.println("llegue al guardarImagenEnFicheroTemporal y el archivo se llama"+ nombreArchivo);
        String ubicacionImagen = null;
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String path = servletContext.getRealPath("") + File.separatorChar + "resources" + File.separatorChar + "images" + File.separatorChar + "tmp" + File.separatorChar + nombreArchivo;
        System.out.println("ruta   "+path);
        File f = null;
        InputStream in = null;
        
        try{
            f = new File(path);
            
            in = new ByteArrayInputStream(bytes);
            FileOutputStream out = new FileOutputStream(f.getAbsolutePath());
            System.out.println("6");
            int c = 0;
            while((c = in.read()) >= 0){
                out.write(c);
            }
            out.flush();
            out.close();
            ubicacionImagen = "../../resources/images/tmp/" +nombreArchivo;
        }
        catch(Exception e){
            System.err.println("no se pudo cargar la imagen error = " + e);
        }
        return ubicacionImagen;
        
    }
    
    
    
}



