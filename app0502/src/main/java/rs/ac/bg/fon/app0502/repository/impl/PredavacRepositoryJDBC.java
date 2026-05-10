/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Katedra;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.domain.Zvanje;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author student2
 */
@Repository(value = "predavacRepositoryJDBC")
public class PredavacRepositoryJDBC implements PredavacRepository{
    private Connection connection;

    @Autowired
    public PredavacRepositoryJDBC(Connection connection) throws SQLException {
        this.connection = connection;
        this.connection.setAutoCommit(false);
    }
    
    
    
    @Override
    public void save(Predavac predavac) {
        try {
            String query = "INSERT INTO predavac(ime,prezime,datum_rodjenja,katedra_id,zvanje_id) VALUES (?,?,?,?,?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, predavac.getIme());
            ps.setString(2, predavac.getPrezime());
            ps.setDate(3, java.sql.Date.valueOf(predavac.getDatumRodjenja()));
            ps.setLong(4, predavac.getKatedra().getId());
            ps.setLong(5, predavac.getZvanje().getId());
            
            ps.executeUpdate();
            connection.commit();
            System.out.println("PredavacRepositoryJDBC.save(): Predavac je dodat!!!");
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex1);
            }
            System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public Predavac findById(Long id) {
        String query = "SELECT id, ime, prezime, datum_rodjenja, katedra_id, zvanje_id FROM predavac WHERE id = ?";

        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("PredavacRepositoryJDBC.findById()");
                    return mapPredavac(rs);
                }
            }
        } catch (SQLException ex) {
            System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return null;
    }

    @Override
    public List<Predavac> findAll() {
        List<Predavac> predavci = new ArrayList<>();
        String query = "SELECT id, ime, prezime, datum_rodjenja, katedra_id, zvanje_id FROM predavac";

        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                predavci.add(mapPredavac(rs));
            }
            
        } catch (SQLException ex) {
            System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
         System.out.println("PredavacRepositoryJDBC.findAll()");
        return predavci;
    }

    @Override
    public void update(Predavac predavac) {
        try {
            String query = "UPDATE predavac SET ime = ?, prezime = ?, datum_rodjenja = ?, katedra_id = ?, zvanje_id = ? WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, predavac.getIme());
                ps.setString(2, predavac.getPrezime());
                ps.setDate(3, java.sql.Date.valueOf(predavac.getDatumRodjenja()));
                ps.setLong(4, predavac.getKatedra().getId());
                ps.setLong(5, predavac.getZvanje().getId());
                ps.setLong(6, predavac.getId());

                int rowsUpdated = ps.executeUpdate();
                connection.commit();

                if (rowsUpdated > 0) {
                    System.out.println("PredavacRepositoryJDBC.update(): Predavac je azuriran!!!");
                } else {
                    System.out.println("PredavacRepositoryJDBC.update(): Predavac nije pronadjen!!!");
                }
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex1);
            }
            System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String query = "DELETE FROM predavac WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setLong(1, id);

                int rowsDeleted = ps.executeUpdate();
                connection.commit();

                if (rowsDeleted > 0) {
                    System.out.println("PredavacRepositoryJDBC.delete(): Predavac je obrisan!!!");
                } else {
                    System.out.println("PredavacRepositoryJDBC.delete(): Predavac nije pronadjen!!!");
                }
            }
        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex1);
            }
            System.getLogger(PredavacRepositoryJDBC.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

        private Predavac mapPredavac(ResultSet rs) throws SQLException {
        return new Predavac(
            rs.getLong("id"),
            rs.getString("ime"),
            rs.getString("prezime"),
            rs.getDate("datum_rodjenja").toLocalDate(),
            new Katedra(rs.getLong("katedra_id")),
            new Zvanje(rs.getLong("zvanje_id")));
        }
    
}
