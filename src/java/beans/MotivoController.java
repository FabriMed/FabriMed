package beans;

import entity.Motivo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "motivoController")
@ViewScoped
public class MotivoController extends AbstractController<Motivo> {

    @Inject
    private CotizacionController cotizacionListController;

    public MotivoController() {
        // Inform the Abstract parent controller of the concrete Motivo?cap_first Entity
        super(Motivo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Cotizacion entities that
     * are retrieved from Motivo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cotizacion page
     */
    public String navigateCotizacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cotizacion_items", this.getSelected().getCotizacionList());
        }
        return "/cotizacion/index";
    }

}
