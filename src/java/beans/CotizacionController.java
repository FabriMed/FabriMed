package beans;

import entity.Cotizacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cotizacionController")
@ViewScoped
public class CotizacionController extends AbstractController<Cotizacion> {

    @Inject
    private MotivoController idMotivoController;
    @Inject
    private DetallecotizacionController detallecotizacionListController;

    public CotizacionController() {
        // Inform the Abstract parent controller of the concrete Cotizacion?cap_first Entity
        super(Cotizacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMotivoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Motivo controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMotivo(ActionEvent event) {
        if (this.getSelected() != null && idMotivoController.getSelected() == null) {
            idMotivoController.setSelected(this.getSelected().getIdMotivo());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Detallecotizacion
     * entities that are retrieved from Cotizacion?cap_first and returns the
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

}
