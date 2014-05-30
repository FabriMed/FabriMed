package beans;

import entity.Producto;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

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
}
