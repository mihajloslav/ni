/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author mihajlo
 */
@Repository(value = "predavacRepositoryJPA")
public class PredavacRepositoryJPA implements PredavacRepository{
    private EntityManagerFactory emf;

    @Autowired
    public PredavacRepositoryJPA(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Predavac predavac) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(predavac);
        em.getTransaction().commit();
        System.out.println("PredavacRepositoryJPA.save(): Predavac je dodat!!!");
        em.close();
    }
    
    
    
    
}
