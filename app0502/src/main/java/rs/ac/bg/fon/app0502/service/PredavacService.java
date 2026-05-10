/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.service;

import java.util.List;
import rs.ac.bg.fon.app0502.dto.PredavacDto;

/**
 *
 * @author student2
 */
public interface PredavacService {
    void save(PredavacDto predavacDto);
    PredavacDto findById(Long id);
    List<PredavacDto> findAll();
    void update(PredavacDto predavacDto);
    void delete(Long id);
}
