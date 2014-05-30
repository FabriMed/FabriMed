/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "motivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Motivo.findAll", query = "SELECT m FROM Motivo m"),
    @NamedQuery(name = "Motivo.findByIdMotivo", query = "SELECT m FROM Motivo m WHERE m.idMotivo = :idMotivo"),
    @NamedQuery(name = "Motivo.findByMotiVigente", query = "SELECT m FROM Motivo m WHERE m.motiVigente = :motiVigente")})
public class Motivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MOTIVO")
    private Integer idMotivo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "MOTI_NOMBRE")
    private String motiNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOTI_VIGENTE")
    private boolean motiVigente;
    @OneToMany(mappedBy = "idMotivo")
    private List<Cotizacion> cotizacionList;

    public Motivo() {
    }

    public Motivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public Motivo(Integer idMotivo, String motiNombre, boolean motiVigente) {
        this.idMotivo = idMotivo;
        this.motiNombre = motiNombre;
        this.motiVigente = motiVigente;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotiNombre() {
        return motiNombre;
    }

    public void setMotiNombre(String motiNombre) {
        this.motiNombre = motiNombre;
    }

    public boolean getMotiVigente() {
        return motiVigente;
    }

    public void setMotiVigente(boolean motiVigente) {
        this.motiVigente = motiVigente;
    }

    @XmlTransient
    public List<Cotizacion> getCotizacionList() {
        return cotizacionList;
    }

    public void setCotizacionList(List<Cotizacion> cotizacionList) {
        this.cotizacionList = cotizacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivo != null ? idMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Motivo)) {
            return false;
        }
        Motivo other = (Motivo) object;
        if ((this.idMotivo == null && other.idMotivo != null) || (this.idMotivo != null && !this.idMotivo.equals(other.idMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Motivo[ idMotivo=" + idMotivo + " ]";
    }
    
}
