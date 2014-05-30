package beans;

import entity.Categoria;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "categoriaController")
@ViewScoped
public class CategoriaController extends AbstractController<Categoria> {

    @Inject
    private ProductoController productoListController;

    public CategoriaController() {
        // Inform the Abstract parent controller of the concrete Categoria?cap_first Entity
        super(Categoria.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Producto entities that
     * are retrieved from Categoria?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Producto page
     */
    public String navigateProductoList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Producto_items", this.getSelected().getProductoList());
        }
        return "/producto/index";
    }

}
