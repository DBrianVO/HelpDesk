/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdvo.PI;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author snak_
 */
@Entity
@Table(name = "especialista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especialista.findAll", query = "SELECT e FROM Especialista e")
    , @NamedQuery(name = "Especialista.findByNoTrabajador", query = "SELECT e FROM Especialista e WHERE e.noTrabajador = :noTrabajador")
    , @NamedQuery(name = "Especialista.findByNombre", query = "SELECT e FROM Especialista e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Especialista.findByCorreo", query = "SELECT e FROM Especialista e WHERE e.correo = :correo")
    , @NamedQuery(name = "Especialista.findByContrasenia", query = "SELECT e FROM Especialista e WHERE e.contrasenia = :contrasenia")})
public class Especialista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "No_Trabajador")
    private Integer noTrabajador;
    @Size(max = 30)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "Correo")
    private String correo;
    @Size(max = 20)
    @Column(name = "Contrasenia")
    private String contrasenia;
    @OneToMany(mappedBy = "especialista")
    private Collection<Ticket> ticketCollection;

    public Especialista() {
    }

    public Especialista(Integer noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    public Integer getNoTrabajador() {
        return noTrabajador;
    }

    public void setNoTrabajador(Integer noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @XmlTransient
    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noTrabajador != null ? noTrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especialista)) {
            return false;
        }
        Especialista other = (Especialista) object;
        if ((this.noTrabajador == null && other.noTrabajador != null) || (this.noTrabajador != null && !this.noTrabajador.equals(other.noTrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bdvo.PI.Especialista[ noTrabajador=" + noTrabajador + " ]";
    }
    
}
