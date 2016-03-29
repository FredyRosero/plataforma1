/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.SimprubassabPreg;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fredy
 */
@Stateless
public class SimprubassabPregFacade extends AbstractFacade<SimprubassabPreg> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SimprubassabPregFacade() {
        super(SimprubassabPreg.class);
    }
    
}
