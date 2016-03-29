/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fredy
 */
@Entity
@Table(name = "simpruebassaber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Simpruebassaber.findAll", query = "SELECT s FROM Simpruebassaber s"),
    @NamedQuery(name = "Simpruebassaber.findByIdSimPruSab", query = "SELECT s FROM Simpruebassaber s WHERE s.idSimPruSab = :idSimPruSab")})
public class Simpruebassaber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSimPruSab")
    private Integer idSimPruSab;
    @JoinColumn(name = "idMareria", referencedColumnName = "idmateria")
    @ManyToOne
    private Materia idMareria;
    @JoinColumn(name = "idGrado", referencedColumnName = "idgrado")
    @ManyToOne
    private Grado idGrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSimPruSab")
    private Collection<SimprubassabPreg> simprubassabPregCollection;

    public Simpruebassaber() {
    }

    public Simpruebassaber(Integer idSimPruSab) {
        this.idSimPruSab = idSimPruSab;
    }

    public Integer getIdSimPruSab() {
        return idSimPruSab;
    }

    public void setIdSimPruSab(Integer idSimPruSab) {
        this.idSimPruSab = idSimPruSab;
    }

    public Materia getIdMareria() {
        return idMareria;
    }

    public void setIdMareria(Materia idMareria) {
        this.idMareria = idMareria;
    }

    public Grado getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Grado idGrado) {
        this.idGrado = idGrado;
    }

    @XmlTransient
    public Collection<SimprubassabPreg> getSimprubassabPregCollection() {
        return simprubassabPregCollection;
    }

    public void setSimprubassabPregCollection(Collection<SimprubassabPreg> simprubassabPregCollection) {
        this.simprubassabPregCollection = simprubassabPregCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSimPruSab != null ? idSimPruSab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Simpruebassaber)) {
            return false;
        }
        Simpruebassaber other = (Simpruebassaber) object;
        if ((this.idSimPruSab == null && other.idSimPruSab != null) || (this.idSimPruSab != null && !this.idSimPruSab.equals(other.idSimPruSab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Simpruebassaber[ idSimPruSab=" + idSimPruSab + " ]";
    }
    
}
