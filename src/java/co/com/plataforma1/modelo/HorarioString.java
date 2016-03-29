/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

public class HorarioString implements Serializable {
    private Integer idhorario;
    @JoinColumn(name = "iddocenteMateria", referencedColumnName = "iddocenteMateria")
    @ManyToOne(optional = false)
    private Docentemateria iddocenteMateria;
    @JoinColumn(name = "idgrado", referencedColumnName = "idgrado")
    @ManyToOne(optional = false)
    private Grado idgrado;
    @JoinColumn(name = "hora", referencedColumnName = "idHoras")
    @ManyToOne(optional = false)
    private Hora hora;
    @JoinColumn(name = "dia", referencedColumnName = "idDia")
    @ManyToOne(optional = false)
    private DiaSem dia;
       
    public HorarioString() {
    }

    public HorarioString(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public HorarioString(Integer idhorario, Hora hora, DiaSem dia) {
        this.idhorario = idhorario;
        this.hora = hora;
        this.dia = dia;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(Integer idhorario) {
        this.idhorario = idhorario;
    }

    public Docentemateria getIddocenteMateria() {
        return iddocenteMateria;
    }

    public void setIddocenteMateria(Docentemateria iddocenteMateria) {
        this.iddocenteMateria = iddocenteMateria;
    }

    public Grado getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Grado idgrado) {
        this.idgrado = idgrado;
    }
    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public DiaSem getDia() {
        return dia;
    }

    public void setDia(DiaSem dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioString)) {
            return false;
        }
        HorarioString other = (HorarioString) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.plataforma1.modelo.Horario[ idhorario=" + idhorario + " ]";
    }
    
}
