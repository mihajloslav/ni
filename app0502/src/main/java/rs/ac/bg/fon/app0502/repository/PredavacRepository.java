/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.repository;

import java.util.List;
import rs.ac.bg.fon.app0502.domain.Predavac;

/**
 *
 * @author student2
 */
public interface PredavacRepository {
    void save(Predavac predavac);
    Predavac findById(Long id);
    List<Predavac> findAll();
    void update(Predavac predavac);
    void delete(Long id);
}
