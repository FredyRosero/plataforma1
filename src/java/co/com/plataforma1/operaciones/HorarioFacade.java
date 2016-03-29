/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Horario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisa
 */
@Stateless
public class HorarioFacade extends AbstractFacade<Horario> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;
    private List<Horario> Lista;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }
    public List<Horario> ListaUsuario(){
    Lista = em.createNamedQuery("Horario.findAll").getResultList();
    return Lista;
    }    
}
