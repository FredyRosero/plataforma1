/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.modelo;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fredy
 */
@Entity
@Table(name = "simprubassab_preg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SimprubassabPreg.findAll", query = "SELECT s FROM SimprubassabPreg s"),
    @NamedQuery(name = "SimprubassabPreg.findByIdPregunta", query = "SELECT s FROM SimprubassabPreg s WHERE s.idPregunta = :idPregunta"),
    @NamedQuery(name = "SimprubassabPreg.findByPregunta", query = "SELECT s FROM SimprubassabPreg s WHERE s.pregunta = :pregunta"),
    @NamedQuery(name = "SimprubassabPreg.findByOpcion1", query = "SELECT s FROM SimprubassabPreg s WHERE s.opcion1 = :opcion1"),
    @NamedQuery(name = "SimprubassabPreg.findByOpcion2", query = "SELECT s FROM SimprubassabPreg s WHERE s.opcion2 = :opcion2"),
    @NamedQuery(name = "SimprubassabPreg.findByOpcion3", query = "SELECT s FROM SimprubassabPreg s WHERE s.opcion3 = :opcion3"),
    @NamedQuery(name = "SimprubassabPreg.findByOpcion4", query = "SELECT s FROM SimprubassabPreg s WHERE s.opcion4 = :opcion4"),
    @NamedQuery(name = "SimprubassabPreg.findByRespuesta", query = "SELECT s FROM SimprubassabPreg s WHERE s.respuesta = :respuesta")})
public class SimprubassabPreg implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPregunta")
    private Integer idPregunta;
    @Size(max = 255)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 255)
    @Column(name = "opcion1")
    private String opcion1;
    @Size(max = 255)
    @Column(name = "opcion2")
    private String opcion2;
    @Size(max = 255)
    @Column(name = "opcion3")
    private String opcion3;
    @Size(max = 255)
    @Column(name = "opcion4")
    private String opcion4;
    @Column(name = "respuesta")
    private Boolean respuesta;
    @JoinColumn(name = "idSimPruSab", referencedColumnName = "idSimPruSab")
    @ManyToOne(optional = false)
    private Simpruebassaber idSimPruSab;

    public SimprubassabPreg() {
    }

    public SimprubassabPreg(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    public Simpruebassaber getIdSimPruSab() {
        return idSimPruSab;
    }

    public void setIdSimPruSab(Simpruebassaber idSimPruSab) {
        this.idSimPruSab = idSimPruSab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SimprubassabPreg)) {
            return false;
        }
        SimprubassabPreg other = (SimprubassabPreg) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.SimprubassabPreg[ idPregunta=" + idPregunta + " ]";
    }
    
}
