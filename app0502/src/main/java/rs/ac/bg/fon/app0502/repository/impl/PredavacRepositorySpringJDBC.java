/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Katedra;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.domain.Zvanje;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author student2
 */
@Repository(value = "predavacRepositorySpringJDBC")
public class PredavacRepositorySpringJDBC implements PredavacRepository{
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PredavacRepositorySpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Predavac predavac) {
        String url = "INSERT INTO predavac(ime,prezime,datum_rodjenja,katedra_id,zvanje_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(url,predavac.getIme(),predavac.getPrezime(),predavac.getDatumRodjenja(),predavac.getKatedra().getId(),predavac.getZvanje().getId());
        System.out.println("PredavacRepositorySpringJDBC.save(): Predavac je dodat!!!");
    }

    @Override
    public Predavac findById(Long id) {
        String query = "SELECT id, ime, prezime, datum_rodjenja, katedra_id, zvanje_id FROM predavac WHERE id = ?";

        try {
            System.out.println("PredavacRepositorySpringJDBC.findById()");
            return jdbcTemplate.queryForObject(query, (ResultSet rs, int rowNum) -> mapPredavac(rs), id);
        } catch (org.springframework.dao.EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Predavac> findAll() {
        String query = "SELECT id, ime, prezime, datum_rodjenja, katedra_id, zvanje_id FROM predavac";
        System.out.println("PredavacRepositorySpringJDBC.findAll()");
        return jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> mapPredavac(rs));
    }

    @Override
    public void update(Predavac predavac) {
        String query = "UPDATE predavac SET ime = ?, prezime = ?, datum_rodjenja = ?, katedra_id = ?, zvanje_id = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(query,
                predavac.getIme(),
                predavac.getPrezime(),
                predavac.getDatumRodjenja(),
                predavac.getKatedra().getId(),
                predavac.getZvanje().getId(),
                predavac.getId());

        if (rowsUpdated > 0) {
            System.out.println("PredavacRepositorySpringJDBC.update(): Predavac je azuriran!!!");
        } else {
            System.out.println("PredavacRepositorySpringJDBC.update(): Predavac nije pronadjen!!!");
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM predavac WHERE id = ?";
        int rowsDeleted = jdbcTemplate.update(query, id);

        if (rowsDeleted > 0) {
            System.out.println("PredavacRepositorySpringJDBC.delete(): Predavac je obrisan!!!");
        } else {
            System.out.println("PredavacRepositorySpringJDBC.delete(): Predavac nije pronadjen!!!");
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
