/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.njtioc1.domain.Investitor;
import rs.ac.bg.fon.njtioc1.domain.Mesto;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;

/**
 *
 * @author student2
 */
@Repository(value = "repoSpringJDBC")
public class SpringJDBCRepository implements ProjectRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringJDBCRepository(JdbcTemplate JdbcTemplate) {
        this.jdbcTemplate = JdbcTemplate;
    }

    @Override
    public Project save(Project p) {
        String query = "INSERT INTO project(id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor) VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(query, p.getId(), p.getNaziv(), p.getDatumPocetka(), p.getDatumZavrsetka(), p.getMesto().getId(), p.getInvestitor().getId());
        System.out.println("SpringJDBCRepository.save():Objekat je dodat!");
        return p;
    }

    @Override
    public void delete(Project p) {
        String query = "DELETE FROM project WHERE id=?";
        int rs = jdbcTemplate.update(query, p.getId());
        if (rs > 0) {
            System.out.println("SpringJDBCRepository.delete():Objekat je obrisan!");
        } else {
            System.out.println("SpringJDBCRepository.delete():Objekat nije obrisan!");
        }
    }

    @Override
    public Project findById(Long id) {
        String query = "SELECT id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor FROM project WHERE id=?";
        System.out.println("SpringJDBCRepository.findById()");
        List<Project> result = jdbcTemplate.query(query, (rs, rowNum) -> mapProject(rs), id);

        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public void update(Project p) {
        String query = "UPDATE project SET id =?, naziv = ?, datum_pocetka = ?, datum_zavrsetka = ?, mesto = ?, investitor = ? WHERE id = ?";

        int rs = jdbcTemplate.update(query, p.getId(), p.getNaziv(), p.getDatumPocetka(), p.getDatumZavrsetka(), p.getMesto().getId(), p.getInvestitor().getId(), p.getId());
        if (rs > 0) {
            System.out.println("SpringJDBCRepository.update():Objekat je azuriran!");
        } else {
            System.out.println("SpringJDBCRepository.update():Objekat nije azuriran!");
        }
    }

    @Override
    public List<Project> findAll() {
        String query = "SELECT id,naziv,datum_pocetka,datum_zavrsetka,mesto,investitor FROM project";
        System.out.println("SpringJDBCRepository.findByAll()");
        return jdbcTemplate.query(query, (ResultSet rs, int rowNum) -> mapProject(rs));
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
