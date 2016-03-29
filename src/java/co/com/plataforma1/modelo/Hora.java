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
 * @author Fredy
 */
@Entity
@Table(name = "hora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hora.findAll", query = "SELECT h FROM Hora h"),
    @NamedQuery(name = "Hora.findByIdHoras", query = "SELECT h FROM Hora h WHERE h.idHoras = :idHoras"),
    @NamedQuery(name = "Hora.findByValorHr", query = "SELECT h FROM Hora h WHERE h.valorHr = :valorHr")})
public class Hora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHoras")
    private Short idHoras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "valor_hr")
    private String valorHr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hora")
    private Collection<Horario> horarioList;

    public Hora() {
    }

    public Hora(Short idHoras) {
        this.idHoras = idHoras;
    }

    public Hora(Short idHoras, String valorHr) {
        this.idHoras = idHoras;
        this.valorHr = valorHr;
    }

    public Short getIdHoras() {
        return idHoras;
    }

    public void setIdHoras(Short idHoras) {
        this.idHoras = idHoras;
    }

    public String getValorHr() {
        return valorHr;
    }

    public void setValorHr(String valorHr) {
        this.valorHr = valorHr;
    }

    @XmlTransient
    public Collection<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(Collection<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHoras != null ? idHoras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hora)) {
            return false;
        }
        Hora other = (Hora) object;
        if ((this.idHoras == null && other.idHoras != null) || (this.idHoras != null && !this.idHoras.equals(other.idHoras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Hora[ idHoras=" + idHoras + " ]";
    }
    
}
