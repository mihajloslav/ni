/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;

/**
 *
 * @author mihajlo
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
    
    
}
