/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author student2
 */
@Repository(value = "predavacRepositoryJPA")
public class PredavacRepositoryJPA implements PredavacRepository{
    private EntityManagerFactory emf;

    @Autowired
    public PredavacRepositoryJPA(@Qualifier(value = "emf")EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Predavac predavac) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(predavac);
            em.getTransaction().commit();
            System.out.println("PredavacRepositoryJPA.save(): Predavac je dodat!!!");
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public Predavac findById(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            Predavac predavac = em.createNamedQuery("Predavac.findById", Predavac.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println("PredavacRepositoryJPA.findById()");
            return new Predavac(
                    predavac.getId(),
                    predavac.getIme(),
                    predavac.getPrezime(),
                    predavac.getDatumRodjenja(),
                    new rs.ac.bg.fon.app0502.domain.Katedra(predavac.getKatedra().getId()),
                    new rs.ac.bg.fon.app0502.domain.Zvanje(predavac.getZvanje().getId()));
        } catch (jakarta.persistence.NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Predavac> findAll() {
        EntityManager em = emf.createEntityManager();

        try {
            List<Predavac> predavci = em.createNamedQuery("Predavac.findAll", Predavac.class).getResultList();
            List<Predavac> rezultat = new java.util.ArrayList<>();
            for (Predavac predavac : predavci) {
                rezultat.add(new Predavac(
                        predavac.getId(),
                        predavac.getIme(),
                        predavac.getPrezime(),
                        predavac.getDatumRodjenja(),
                        new rs.ac.bg.fon.app0502.domain.Katedra(predavac.getKatedra().getId()),
                        new rs.ac.bg.fon.app0502.domain.Zvanje(predavac.getZvanje().getId())));
            }
             System.out.println("PredavacRepositoryJPA.findAll()");
            return rezultat;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Predavac predavac) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Predavac managed = em.merge(predavac);
            em.getTransaction().commit();
            System.out.println("PredavacRepositoryJPA.update(): Predavac je azuriran!!!");
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Predavac predavac = em.find(Predavac.class, id);
            if (predavac != null) {
                em.remove(predavac);
                em.getTransaction().commit();
                System.out.println("PredavacRepositoryJPA.delete(): Predavac je obrisan!!!");
            } else {
                em.getTransaction().rollback();
                System.out.println("PredavacRepositoryJPA.delete(): Predavac nije pronadjen!!!");
            }
        } catch (RuntimeException ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
    
    
    
    
}
