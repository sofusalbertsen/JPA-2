/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.cphbusiness.jpa.tester;

import dk.cphbusiness.jpa.Address;
import dk.cphbusiness.jpa.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sofus
 */
public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        
        Person p = new Person("a","b");
        Address a = new Address();
        a.setStreetName("Nørrebrogade");
        p.setAddress(a);
        a.setPerson(p);
        em.getTransaction().begin();
        
        em.persist(p);
        em.flush();
        em.clear();
        em.getTransaction().commit();
        Person p2 = em.find(Person.class, 1L);
        em.close();
        System.out.println(p2.getaList().get(0).getStreetName());
        
        
    }
    
}
