/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.plataforma1.operaciones;

import co.com.plataforma1.modelo.Simpruebassaber;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Fredy
 */
@Stateless
public class SimpruebassaberFacade extends AbstractFacade<Simpruebassaber> {

    @PersistenceContext(unitName = "plataforma1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SimpruebassaberFacade() {
        super(Simpruebassaber.class);
    }
    
}
