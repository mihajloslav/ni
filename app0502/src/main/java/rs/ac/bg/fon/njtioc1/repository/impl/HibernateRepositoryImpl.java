/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.repository.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;

/**
 *
 * @author student2
 */
@Repository(value="repoHibernate")
public class HibernateRepositoryImpl implements ProjectRepository{
    private SessionFactory sf;

    @Autowired
    public HibernateRepositoryImpl(@Qualifier(value="sf")SessionFactory sf) {
        this.sf = sf;
    }
     

    @Override
    public Project save(Project p) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        
        Project pr = session.merge(p);
        
        
        
        transaction.commit();
        session.close();
        System.out.println("HibernateRepositoryImpl.save(): Objekat je uspešno sačuvan");
        return pr;
    }

    @Override
    public void delete(Project p) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        
        
        
        Project pr = session.find(Project.class, p.getId());
        
        
        
        
        if(pr != null){
            session.remove(pr);
            System.out.println("HibernateRepositoryImpl.delete(): Objekat je uspešno obrisan");
        }
        else{
            System.out.println("HibernateRepositoryImpl.delete(): Objekat ne postoji u bazi!");
        }
        transaction.commit();
        session.close();
        
    }

    @Override
    public Project findById(Long id) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        
        
        Project p = session.find(Project.class, id);
        
        
        
        t.commit();
        session.close();
        System.out.println("HibernateRepositoryImpl.findById()");
        return p; 
    }

    @Override
    public void update(Project p) {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        
        
        session.merge(p);
        
        
        t.commit();
        session.close();
        
        System.out.println("HibernateRepositoryImpl.update(): Objekat je ažuriran!");
        
    }

    @Override
    public List<Project> findAll() {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();
        
        
        List<Project> lista = session.createQuery("SELECT p FROM Project p", Project.class).getResultList();
        
        
        t.commit();
        session.close();
        System.out.println("HibernateRepositoryImpl.findAll()");
        return lista;
    }

    
    
}
