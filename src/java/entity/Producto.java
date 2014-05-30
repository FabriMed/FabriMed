/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByProdCodigo", query = "SELECT p FROM Producto p WHERE p.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "Producto.findByProdNombre", query = "SELECT p FROM Producto p WHERE p.prodNombre = :prodNombre"),
    @NamedQuery(name = "Producto.findByProdMedidas", query = "SELECT p FROM Producto p WHERE p.prodMedidas = :prodMedidas"),
    @NamedQuery(name = "Producto.findByProdUrl", query = "SELECT p FROM Producto p WHERE p.prodUrl = :prodUrl"),
    @NamedQuery(name = "Producto.findByProdVigente", query = "SELECT p FROM Producto p WHERE p.prodVigente = :prodVigente")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_CODIGO")
    private int prodCodigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "PROD_NOMBRE")
    private String prodNombre;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PROD_DESCRIPCION")
    private String prodDescripcion;
    @Size(max = 150)
    @Column(name = "PROD_MEDIDAS")
    private String prodMedidas;
    @Size(max = 150)
    @Column(name = "PROD_URL")
    private String prodUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROD_VIGENTE")
    private boolean prodVigente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Detallecotizacion> detallecotizacionList;
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    @ManyToOne(optional = false)
    private Categoria idCategoria;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, int prodCodigo, String prodNombre, boolean prodVigente) {
        this.idProducto = idProducto;
        this.prodCodigo = prodCodigo;
        this.prodNombre = prodNombre;
        this.prodVigente = prodVigente;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public int getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(int prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public String getProdNombre() {
        return prodNombre;
    }

    public void setProdNombre(String prodNombre) {
        this.prodNombre = prodNombre;
    }

    public String getProdDescripcion() {
        return prodDescripcion;
    }

    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }

    public String getProdMedidas() {
        return prodMedidas;
    }

    public void setProdMedidas(String prodMedidas) {
        this.prodMedidas = prodMedidas;
    }

    public String getProdUrl() {
        return prodUrl;
    }

    public void setProdUrl(String prodUrl) {
        this.prodUrl = prodUrl;
    }

    public boolean getProdVigente() {
        return prodVigente;
    }

    public void setProdVigente(boolean prodVigente) {
        this.prodVigente = prodVigente;
    }

    @XmlTransient
    public List<Detallecotizacion> getDetallecotizacionList() {
        return detallecotizacionList;
    }

    public void setDetallecotizacionList(List<Detallecotizacion> detallecotizacionList) {
        this.detallecotizacionList = detallecotizacionList;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
