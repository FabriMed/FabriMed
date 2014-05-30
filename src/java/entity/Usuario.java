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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emanuel
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByUsuaCuenta", query = "SELECT u FROM Usuario u WHERE u.usuaCuenta = :usuaCuenta"),
    @NamedQuery(name = "Usuario.findByUsuaContrasena", query = "SELECT u FROM Usuario u WHERE u.usuaContrasena = :usuaContrasena"),
    @NamedQuery(name = "Usuario.findByUsuaNombre", query = "SELECT u FROM Usuario u WHERE u.usuaNombre = :usuaNombre"),
    @NamedQuery(name = "Usuario.findByUsuaApellido", query = "SELECT u FROM Usuario u WHERE u.usuaApellido = :usuaApellido"),
    @NamedQuery(name = "Usuario.findByUsuaTelefono", query = "SELECT u FROM Usuario u WHERE u.usuaTelefono = :usuaTelefono"),
    @NamedQuery(name = "Usuario.findByUsuaTelefono2", query = "SELECT u FROM Usuario u WHERE u.usuaTelefono2 = :usuaTelefono2"),
    @NamedQuery(name = "Usuario.findByUsuaEmail", query = "SELECT u FROM Usuario u WHERE u.usuaEmail = :usuaEmail"),
    @NamedQuery(name = "Usuario.findByUsuaVigente", query = "SELECT u FROM Usuario u WHERE u.usuaVigente = :usuaVigente")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUA_CUENTA")
    private String usuaCuenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUA_CONTRASENA")
    private String usuaContrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUA_NOMBRE")
    private String usuaNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "USUA_APELLIDO")
    private String usuaApellido;
    @Size(max = 25)
    @Column(name = "USUA_TELEFONO")
    private String usuaTelefono;
    @Size(max = 25)
    @Column(name = "USUA_TELEFONO2")
    private String usuaTelefono2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "USUA_EMAIL")
    private String usuaEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USUA_VIGENTE")
    private boolean usuaVigente;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String usuaCuenta, String usuaContrasena, String usuaNombre, String usuaApellido, String usuaEmail, boolean usuaVigente) {
        this.idUsuario = idUsuario;
        this.usuaCuenta = usuaCuenta;
        this.usuaContrasena = usuaContrasena;
        this.usuaNombre = usuaNombre;
        this.usuaApellido = usuaApellido;
        this.usuaEmail = usuaEmail;
        this.usuaVigente = usuaVigente;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuaCuenta() {
        return usuaCuenta;
    }

    public void setUsuaCuenta(String usuaCuenta) {
        this.usuaCuenta = usuaCuenta;
    }

    public String getUsuaContrasena() {
        return usuaContrasena;
    }

    public void setUsuaContrasena(String usuaContrasena) {
        this.usuaContrasena = usuaContrasena;
    }

    public String getUsuaNombre() {
        return usuaNombre;
    }

    public void setUsuaNombre(String usuaNombre) {
        this.usuaNombre = usuaNombre;
    }

    public String getUsuaApellido() {
        return usuaApellido;
    }

    public void setUsuaApellido(String usuaApellido) {
        this.usuaApellido = usuaApellido;
    }

    public String getUsuaTelefono() {
        return usuaTelefono;
    }

    public void setUsuaTelefono(String usuaTelefono) {
        this.usuaTelefono = usuaTelefono;
    }

    public String getUsuaTelefono2() {
        return usuaTelefono2;
    }

    public void setUsuaTelefono2(String usuaTelefono2) {
        this.usuaTelefono2 = usuaTelefono2;
    }

    public String getUsuaEmail() {
        return usuaEmail;
    }

    public void setUsuaEmail(String usuaEmail) {
        this.usuaEmail = usuaEmail;
    }

    public boolean getUsuaVigente() {
        return usuaVigente;
    }

    public void setUsuaVigente(boolean usuaVigente) {
        this.usuaVigente = usuaVigente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
