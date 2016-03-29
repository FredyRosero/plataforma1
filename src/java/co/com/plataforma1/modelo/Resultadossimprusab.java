/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fredy
 */
@Entity
@Table(name = "resultadossimprusab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultadossimprusab.findAll", query = "SELECT r FROM Resultadossimprusab r"),
    @NamedQuery(name = "Resultadossimprusab.findByIdResSimPruSab", query = "SELECT r FROM Resultadossimprusab r WHERE r.idResSimPruSab = :idResSimPruSab"),
    @NamedQuery(name = "Resultadossimprusab.findByFecha", query = "SELECT r FROM Resultadossimprusab r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Resultadossimprusab.findByCalificacion", query = "SELECT r FROM Resultadossimprusab r WHERE r.calificacion = :calificacion")})
public class Resultadossimprusab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResSimPruSab")
    private Integer idResSimPruSab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private float calificacion;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante")
    @ManyToOne(optional = false)
    private Estudiante idestudiante;

    public Resultadossimprusab() {
    }

    public Resultadossimprusab(Integer idResSimPruSab) {
        this.idResSimPruSab = idResSimPruSab;
    }

    public Resultadossimprusab(Integer idResSimPruSab, Date fecha, float calificacion) {
        this.idResSimPruSab = idResSimPruSab;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }

    public Integer getIdResSimPruSab() {
        return idResSimPruSab;
    }

    public void setIdResSimPruSab(Integer idResSimPruSab) {
        this.idResSimPruSab = idResSimPruSab;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public Estudiante getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Estudiante idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResSimPruSab != null ? idResSimPruSab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultadossimprusab)) {
            return false;
        }
        Resultadossimprusab other = (Resultadossimprusab) object;
        if ((this.idResSimPruSab == null && other.idResSimPruSab != null) || (this.idResSimPruSab != null && !this.idResSimPruSab.equals(other.idResSimPruSab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Resultadossimprusab[ idResSimPruSab=" + idResSimPruSab + " ]";
    }
    
}
