/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Katedra;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.domain.Zvanje;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author mihajlo
 */
@Repository(value = "predavacRepositoryHibernate")
public class PredavacRepositoryHibernate implements PredavacRepository{

    private SessionFactory sessionFactory;
    @Autowired
    public PredavacRepositoryHibernate(@Qualifier(value="sf")SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    
    @Override
    public void save(Predavac predavac) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(predavac);
        transaction.commit();
        System.out.println("PredavacRepositoryHibernate.save(): Predavac je uspesno dodat!!!");
        
    }

    @Override
    public Predavac findById(Long id) {
        Session session = sessionFactory.openSession();
        try {
            Predavac predavac = session.createNamedQuery("Predavac.findById", Predavac.class)
                    .setParameter("id", id)
                    .uniqueResult();
            
            if (predavac != null) {
                return new Predavac(
                        predavac.getId(),
                        predavac.getIme(),
                        predavac.getPrezime(),
                        predavac.getDatumRodjenja(),
                        new Katedra(predavac.getKatedra().getId()),
                        new Zvanje(predavac.getZvanje().getId()));
            }
        } catch (Exception ex) {
            System.getLogger(PredavacRepositoryHibernate.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            session.close();
        }
        
        return null;
    }

    @Override
    public List<Predavac> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List<Predavac> predavci = session.createNamedQuery("Predavac.findAll", Predavac.class).list();
            
            List<Predavac> rezultat = new ArrayList<>();
            for (Predavac predavac : predavci) {
                rezultat.add(new Predavac(
                        predavac.getId(),
                        predavac.getIme(),
                        predavac.getPrezime(),
                        predavac.getDatumRodjenja(),
                        new Katedra(predavac.getKatedra().getId()),
                        new Zvanje(predavac.getZvanje().getId())));
            }
            return rezultat;
        } catch (Exception ex) {
            System.getLogger(PredavacRepositoryHibernate.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            session.close();
        }
        
        return new ArrayList<>();
    }

    @Override
    public void update(Predavac predavac) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Predavac existing = session.get(Predavac.class, predavac.getId());
            if (existing != null) {
                existing.setIme(predavac.getIme());
                existing.setPrezime(predavac.getPrezime());
                existing.setDatumRodjenja(predavac.getDatumRodjenja());
                existing.setKatedra(predavac.getKatedra());
                existing.setZvanje(predavac.getZvanje());
                
                session.merge(existing);
                transaction.commit();
                
                System.out.println("PredavacRepositoryHibernate.update(): Predavac je azuriran!!!");
            } else {
                System.out.println("PredavacRepositoryHibernate.update(): Predavac nije pronadjen!!!");
            }
        } catch (Exception ex) {
            transaction.rollback();
            System.getLogger(PredavacRepositoryHibernate.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Predavac predavac = session.get(Predavac.class, id);
            if (predavac != null) {
                session.remove(predavac);
                transaction.commit();
                
                System.out.println("PredavacRepositoryHibernate.delete(): Predavac je obrisan!!!");
            } else {
                System.out.println("PredavacRepositoryHibernate.delete(): Predavac nije pronadjen!!!");
            }
        } catch (Exception ex) {
            transaction.rollback();
            System.getLogger(PredavacRepositoryHibernate.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            session.close();
        }
    }
    
}