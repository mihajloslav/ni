/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.lang.annotation.Annotation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;

/**
 *
 * @author student2
 */
@Repository(value="repoJPA")
public class JPARepositoryImpl  implements ProjectRepository{

    private EntityManagerFactory emf;

    @Autowired
    public JPARepositoryImpl(@Qualifier(value="emf")EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    @Override
    public Project save(Project p) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Project pr = em.merge(p);
        em.getTransaction().commit();
        em.close();
        System.out.println("JPARepositoryImpl.save(): Objekat je uspešno sačuvan");
        return pr;
        
    }

    @Override
    public void delete(Project p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Project pr = em.find(Project.class, p.getId());
        if(pr != null){
            em.remove(pr);
            System.out.println("JPARepositoryImpl.delete():Objekat je uspešno obrisan!");
        }
        else
            System.out.println("JPARepositoryImpl.delete():Objekat ne postoji u bazi!");
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Project findById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Project p = em.find(Project.class, id);
        em.getTransaction().commit();
        em.close();
        return p;
        
    }

    @Override
    public void update(Project p) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(p);
        
        em.getTransaction().commit();
        em.close();
        
        
        System.out.println("JPARepositoryImpl.update(): Objekat je uspešno azuriran");
    }

    @Override
    public List<Project> findAll() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Project> lista = em.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println("JPARepositoryImpl.findAll()");
        return lista;
    }

    
}
