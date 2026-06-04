/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njtioc1.domain.Investitor;
import rs.ac.bg.fon.njtioc1.domain.Mesto;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;

/**
 *
 * @author student2
 */
@Repository(value = "repoJDBC")
public class JDBCRepository implements ProjectRepository {

    public Connection connection;

    @Autowired
    public JDBCRepository(Connection connection) throws SQLException {
        this.connection = connection;
        connection.setAutoCommit(false);
    }

    @Override
    public Project save(Project p) {
        try {
            String query = "INSERT INTO project(id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getId());
            ps.setString(2, p.getNaziv());
            ps.setDate(3, java.sql.Date.valueOf(p.getDatumPocetka()));
            ps.setDate(4, java.sql.Date.valueOf(p.getDatumZavrsetka()));
            ps.setLong(5, p.getMesto().getId());
            ps.setLong(6, p.getInvestitor().getId());

            int rs = ps.executeUpdate();
            connection.commit();
            if (rs > 0) {
                System.out.println("JDBCRepository.save():Objekat je uspešno sačuvan!");
            } else {
                System.out.println("JDBCRepository.save():Objekat nije sačuvan!");
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;

    }

    @Override
    public void delete(Project p) {
        try {
            String query = "DELETE FROM project WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getId());
            int rs = ps.executeUpdate();
            connection.commit();
            if (rs > 0) {
                System.out.println("JDBCRepository.save():Objekat je uspešno obrisan!");
            } else {
                System.out.println("JDBCRepository.save():Objekat nije obrisan!");
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Project findById(Long id) {
        try {
            String query = "SELECT id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor FROM project WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("JDBCRepository.findById()");
                return mapProject(rs);
            }
        } catch (SQLException ex) {
            System.out.println("JDBCRepository.findById()");
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void update(Project p) {
        try {
            String query = "UPDATE project SET id =?, naziv = ?, datum_pocetka = ?, datum_zavrsetka = ?, mesto = ?, investitor = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, p.getId());
            ps.setString(2, p.getNaziv());
            ps.setDate(3, java.sql.Date.valueOf(p.getDatumPocetka()));
            ps.setDate(4, java.sql.Date.valueOf(p.getDatumZavrsetka()));
            ps.setLong(5, p.getMesto().getId());
            ps.setLong(6, p.getInvestitor().getId());

            int rs = ps.executeUpdate();
            connection.commit();
            if (rs > 0) {
                System.out.println("JDBCRepository.update():Objekat je uspešno ažuriran!");
            } else {
                System.out.println("JDBCRepository.update():Objekat nije ažuriran!");
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Project> findAll() {
        try {
            String query = "SELECT id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor FROM project";
            PreparedStatement ps = connection.prepareStatement(query);
            List<Project> lista = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lista.add(mapProject(rs));
            }
            System.out.println("JDBCRepository.findByAll()");
            return lista;
        } catch (SQLException ex) {
            System.out.println("JDBCRepository.findByAll()");
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(JDBCRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Project mapProject(ResultSet rs) throws SQLException{
        return new Project(rs.getLong("id"),
                rs.getString("naziv"),
                rs.getDate("datum_pocetka").toLocalDate(),
                rs.getDate("datum_zavrsetka").toLocalDate(),
                new Mesto(rs.getLong("mesto"), null),
                new Investitor(rs.getLong("investitor"),null, null, null, new Mesto()));
                
    }
}
