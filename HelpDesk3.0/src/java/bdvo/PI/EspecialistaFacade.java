/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdvo.PI;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author snak_
 */
@Stateless
public class EspecialistaFacade extends AbstractFacade<Especialista> {

    @PersistenceContext(unitName = "HelpDesk3.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EspecialistaFacade() {
        super(Especialista.class);
    }
    
}
