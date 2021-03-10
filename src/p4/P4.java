/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;

import entities.Kniha;
import entities.Osoba;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vsa
 */
public class P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kniha k = new Kniha("Jazyk C");
        Osoba kernigen = new Osoba("Kernigen");
        Osoba ritchie = new Osoba("Ritchie");
        
        k.getAutory().add(kernigen);
        k.getAutory().add(ritchie);
        
        persist(kernigen);
        persist(ritchie);
        persist(k);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("p4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
