package beans;

import entity.Detallecotizacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "detallecotizacionController")
@ViewScoped
public class DetallecotizacionController extends AbstractController<Detallecotizacion> {

    @Inject
    private ProductoController idProductoController;
    @Inject
    private CotizacionController idCotizacionController;

    public DetallecotizacionController() {
        // Inform the Abstract parent controller of the concrete Detallecotizacion?cap_first Entity
        super(Detallecotizacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idProductoController.setSelected(null);
        idCotizacionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Producto controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdProducto(ActionEvent event) {
        if (this.getSelected() != null && idProductoController.getSelected() == null) {
            idProductoController.setSelected(this.getSelected().getIdProducto());
        }
    }

    /**
     * Sets the "selected" attribute of the Cotizacion controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCotizacion(ActionEvent event) {
        if (this.getSelected() != null && idCotizacionController.getSelected() == null) {
            idCotizacionController.setSelected(this.getSelected().getIdCotizacion());
        }
    }
}
