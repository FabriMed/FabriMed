/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "cotizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cotizacion.findAll", query = "SELECT c FROM Cotizacion c"),
    @NamedQuery(name = "Cotizacion.findByIdCotizacion", query = "SELECT c FROM Cotizacion c WHERE c.idCotizacion = :idCotizacion"),
    @NamedQuery(name = "Cotizacion.findByCotiNombre", query = "SELECT c FROM Cotizacion c WHERE c.cotiNombre = :cotiNombre"),
    @NamedQuery(name = "Cotizacion.findByCotiApellido", query = "SELECT c FROM Cotizacion c WHERE c.cotiApellido = :cotiApellido"),
    @NamedQuery(name = "Cotizacion.findByCotiEmail", query = "SELECT c FROM Cotizacion c WHERE c.cotiEmail = :cotiEmail"),
    @NamedQuery(name = "Cotizacion.findByCotiTelefono", query = "SELECT c FROM Cotizacion c WHERE c.cotiTelefono = :cotiTelefono"),
    @NamedQuery(name = "Cotizacion.findByCotiFecha", query = "SELECT c FROM Cotizacion c WHERE c.cotiFecha = :cotiFecha")})
public class Cotizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COTIZACION")
    private Integer idCotizacion;
    @Size(max = 100)
    @Column(name = "COTI_NOMBRE")
    private String cotiNombre;
    @Size(max = 100)
    @Column(name = "COTI_APELLIDO")
    private String cotiApellido;
    @Size(max = 128)
    @Column(name = "COTI_EMAIL")
    private String cotiEmail;
    @Size(max = 25)
    @Column(name = "COTI_TELEFONO")
    private String cotiTelefono;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "COTI_OBSERVACIONES")
    private String cotiObservaciones;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "COTI_ESPECIFICACIONES")
    private String cotiEspecificaciones;
    @Column(name = "COTI_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cotiFecha;
    @JoinColumn(name = "ID_MOTIVO", referencedColumnName = "ID_MOTIVO")
    @ManyToOne
    private Motivo idMotivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCotizacion")
    private List<Detallecotizacion> detallecotizacionList;

    public Cotizacion() {
    }

    public Cotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public Integer getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Integer idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getCotiNombre() {
        return cotiNombre;
    }

    public void setCotiNombre(String cotiNombre) {
        this.cotiNombre = cotiNombre;
    }

    public String getCotiApellido() {
        return cotiApellido;
    }

    public void setCotiApellido(String cotiApellido) {
        this.cotiApellido = cotiApellido;
    }

    public String getCotiEmail() {
        return cotiEmail;
    }

    public void setCotiEmail(String cotiEmail) {
        this.cotiEmail = cotiEmail;
    }

    public String getCotiTelefono() {
        return cotiTelefono;
    }

    public void setCotiTelefono(String cotiTelefono) {
        this.cotiTelefono = cotiTelefono;
    }

    public String getCotiObservaciones() {
        return cotiObservaciones;
    }

    public void setCotiObservaciones(String cotiObservaciones) {
        this.cotiObservaciones = cotiObservaciones;
    }

    public String getCotiEspecificaciones() {
        return cotiEspecificaciones;
    }

    public void setCotiEspecificaciones(String cotiEspecificaciones) {
        this.cotiEspecificaciones = cotiEspecificaciones;
    }

    public Date getCotiFecha() {
        return cotiFecha;
    }

    public void setCotiFecha(Date cotiFecha) {
        this.cotiFecha = cotiFecha;
    }

    public Motivo getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Motivo idMotivo) {
        this.idMotivo = idMotivo;
    }

    @XmlTransient
    public List<Detallecotizacion> getDetallecotizacionList() {
        return detallecotizacionList;
    }

    public void setDetallecotizacionList(List<Detallecotizacion> detallecotizacionList) {
        this.detallecotizacionList = detallecotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCotizacion != null ? idCotizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cotizacion)) {
            return false;
        }
        Cotizacion other = (Cotizacion) object;
        if ((this.idCotizacion == null && other.idCotizacion != null) || (this.idCotizacion != null && !this.idCotizacion.equals(other.idCotizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cotizacion[ idCotizacion=" + idCotizacion + " ]";
    }
    
}
