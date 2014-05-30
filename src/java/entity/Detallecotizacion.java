/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "detallecotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallecotizacion.findAll", query = "SELECT d FROM Detallecotizacion d"),
    @NamedQuery(name = "Detallecotizacion.findByIdDetallecotizacion", query = "SELECT d FROM Detallecotizacion d WHERE d.idDetallecotizacion = :idDetallecotizacion"),
    @NamedQuery(name = "Detallecotizacion.findByDecoCantidad", query = "SELECT d FROM Detallecotizacion d WHERE d.decoCantidad = :decoCantidad")})
public class Detallecotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLECOTIZACION")
    private Integer idDetallecotizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DECO_CANTIDAD")
    private int decoCantidad;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "ID_COTIZACION", referencedColumnName = "ID_COTIZACION")
    @ManyToOne(optional = false)
    private Cotizacion idCotizacion;

    public Detallecotizacion() {
    }

    public Detallecotizacion(Integer idDetallecotizacion) {
        this.idDetallecotizacion = idDetallecotizacion;
    }

    public Detallecotizacion(Integer idDetallecotizacion, int decoCantidad) {
        this.idDetallecotizacion = idDetallecotizacion;
        this.decoCantidad = decoCantidad;
    }

    public Integer getIdDetallecotizacion() {
        return idDetallecotizacion;
    }

    public void setIdDetallecotizacion(Integer idDetallecotizacion) {
        this.idDetallecotizacion = idDetallecotizacion;
    }

    public int getDecoCantidad() {
        return decoCantidad;
    }

    public void setDecoCantidad(int decoCantidad) {
        this.decoCantidad = decoCantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Cotizacion getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Cotizacion idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallecotizacion != null ? idDetallecotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallecotizacion)) {
            return false;
        }
        Detallecotizacion other = (Detallecotizacion) object;
        if ((this.idDetallecotizacion == null && other.idDetallecotizacion != null) || (this.idDetallecotizacion != null && !this.idDetallecotizacion.equals(other.idDetallecotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Detallecotizacion[ idDetallecotizacion=" + idDetallecotizacion + " ]";
    }
    
}
