package beans;

import entity.Producto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.CroppedImage;

@Named(value = "productoController")
@ViewScoped
public class ProductoController extends AbstractController<Producto> {

    @Inject
    private DetallecotizacionController detallecotizacionListController;
    @Inject
    private CategoriaController idCategoriaController;

    public ProductoController() {
        // Inform the Abstract parent controller of the concrete Producto?cap_first Entity
        super(Producto.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCategoriaController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Detallecotizacion
     * entities that are retrieved from Producto?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Detallecotizacion page
     */
    public String navigateDetallecotizacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Detallecotizacion_items", this.getSelected().getDetallecotizacionList());
        }
        return "/detallecotizacion/index";
    }

    /**
     * Sets the "selected" attribute of the Categoria controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCategoria(ActionEvent event) {
        if (this.getSelected() != null && idCategoriaController.getSelected() == null) {
            idCategoriaController.setSelected(this.getSelected().getIdCategoria());
        }
    }
    
    private Producto producto; 
    private CroppedImage croppeFoto; 
    private String imageTemp; 
    
    public void actionFoto(){    
        this.croppeFoto = null;   
        this.imageTemp = null; 
    } 
    
    public void actionGuardarFoto(){     
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images");     
        String archivo = path + "nombreImagenEstatica.jpg";      
        try {           
   
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
                    
            actionFoto();       
        } catch (FileNotFoundException e) {
            e.printStackTrace();    
        } catch (IOException e) {
            e.printStackTrace();     
        } 
    }
    public void uploadFile(FileUploadEvent event) {
        try {        
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/tmp"); 
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

    public String getImageTemp() {
        return imageTemp;
    }

    public void setImageTemp(String imageTemp) {
        this.imageTemp = imageTemp;
    }
}
