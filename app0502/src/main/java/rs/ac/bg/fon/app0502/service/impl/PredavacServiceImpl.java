/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.bg.fon.app0502.domain.Katedra;
import rs.ac.bg.fon.app0502.domain.Predavac;
import rs.ac.bg.fon.app0502.domain.Zvanje;
import rs.ac.bg.fon.app0502.dto.KatedraDto;
import rs.ac.bg.fon.app0502.dto.PredavacDto;
import rs.ac.bg.fon.app0502.dto.ZvanjeDto;
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
        predavacRepository.save(toFullEntity(predavacDto));
    }

    @Override
    public PredavacDto findById(Long id) {
        Predavac predavac = predavacRepository.findById(id);
        return predavac == null ? null : toDto(predavac);
    }

    @Override
    public List<PredavacDto> findAll() {
        List<PredavacDto> predavci = new ArrayList<>();
        for (Predavac predavac : predavacRepository.findAll()) {
            predavci.add(toDto(predavac));
        }
        return predavci;
    }

    @Override
    public void update(PredavacDto predavacDto) {
        System.out.println("Pozvana metoda PredavacServiceImpl.update()");
        predavacRepository.update(toFullEntity(predavacDto));
    }

    @Override
    public void delete(Long id) {
        System.out.println("Pozvana metoda PredavacServiceImpl.delete()");
        predavacRepository.delete(id);
    }

    private Predavac toFullEntity(PredavacDto predavacDto) {
        return new Predavac(
                predavacDto.getId(),
                predavacDto.getIme(),
                predavacDto.getPrezime(),
                predavacDto.getDatumRodjenja(),
                new Katedra(predavacDto.getKatedra().getId(), predavacDto.getKatedra().getNaziv(), predavacDto.getKatedra().getSkraceniNaziv()),
                new Zvanje(predavacDto.getZvanje().getId(), predavacDto.getZvanje().getSrpskiNaziv(), predavacDto.getZvanje().getEngleskiNaziv()));
    }

    private PredavacDto toDto(Predavac predavac) {
        Katedra katedra = predavac.getKatedra();
        Zvanje zvanje = predavac.getZvanje();

        return new PredavacDto(
                predavac.getId(),
                predavac.getIme(),
                predavac.getPrezime(),
                predavac.getDatumRodjenja(),
                katedra == null ? null : new KatedraDto(katedra.getId()),
                zvanje == null ? null : new ZvanjeDto(zvanje.getId()));
    }
    
}
