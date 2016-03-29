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
@Table(name = "dia_sem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DiaSem.findAll", query = "SELECT d FROM DiaSem d"),
    @NamedQuery(name = "DiaSem.findByIdDia", query = "SELECT d FROM DiaSem d WHERE d.idDia = :idDia"),
    @NamedQuery(name = "DiaSem.findByValor", query = "SELECT d FROM DiaSem d WHERE d.valor = :valor")})
public class DiaSem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDia")
    private Short idDia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "valor")
    private String valor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dia")
    private Collection<Horario> horarioList;

    public DiaSem() {
    }

    public DiaSem(Short idDia) {
        this.idDia = idDia;
    }

    public DiaSem(Short idDia, String valor) {
        this.idDia = idDia;
        this.valor = valor;
    }

    public Short getIdDia() {
        return idDia;
    }

    public void setIdDia(Short idDia) {
        this.idDia = idDia;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
        hash += (idDia != null ? idDia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaSem)) {
            return false;
        }
        DiaSem other = (DiaSem) object;
        if ((this.idDia == null && other.idDia != null) || (this.idDia != null && !this.idDia.equals(other.idDia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return valor;
    }
    
}
