/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.bg.fon.app0502.domain.Katedra;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.domain.Zvanje;
import rs.ac.bg.fon.app0502.dto.PredavacDto;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;
import rs.ac.bg.fon.app0502.service.PredavacService;

/**
 *
 * @author student2
 */
public class PredavacServiceImpl implements PredavacService{
    private PredavacRepository predavacRepository;

    @Autowired
    public PredavacServiceImpl(PredavacRepository predavacRepository) {
        this.predavacRepository = predavacRepository;
    }
    
    

    @Override
    public void save(PredavacDto predavacDto) {
        System.out.println("Pozvana metoda PredavacServiceImpl.save()");
        Katedra katedra = new Katedra(predavacDto.getKatedra().getId(), predavacDto.getKatedra().getNaziv(), predavacDto.getKatedra().getSkraceniNaziv());
        Zvanje zvanje = new Zvanje(predavacDto.getZvanje().getId(), predavacDto.getZvanje().getSrpskiNaziv(), predavacDto.getZvanje().getEngleskiNaziv());
        
        predavacRepository.save(new Predavac(predavacDto.getId(), predavacDto.getIme(), predavacDto.getPrezime(), predavacDto.getDatumRodjenja(), katedra, zvanje));
    }
    
}
