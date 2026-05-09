/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author mihajlo
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
            ps.setDate(3, new java.sql.Date(predavac.getDatumRodjenja().getTime()));
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
    
}
