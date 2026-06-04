/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.converter.impl;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njtioc1.converter.Converter;
import rs.ac.bg.fon.njtioc1.domain.Investitor;
import rs.ac.bg.fon.njtioc1.domain.Mesto;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.dto.InvestitorDto;
import rs.ac.bg.fon.njtioc1.dto.MestoDto;
import rs.ac.bg.fon.njtioc1.dto.ProjectDto;

/**
 *
 * @author student2
 */
@Component
public class ConverterImpl implements Converter<ProjectDto, Project>{

    @Override
    public Project toEntity(ProjectDto dto) {
        Mesto mesto = new Mesto(dto.getMesto().getId(), dto.getMesto().getIme());
        
        Mesto mestoInv = new Mesto(dto.getInvestitor().getSrediste().getId(), dto.getInvestitor().getSrediste().getIme());
        
        Investitor investitor = new Investitor(dto.getInvestitor().getId(), dto.getInvestitor().getNaziv(), 
                dto.getInvestitor().getPib(), dto.getInvestitor().getMaticniBroj(), mestoInv);

        return new Project(dto.getId(), dto.getNaziv(), dto.getDatumPocetka(), dto.getDatumZavrsetka(), 
                mesto, investitor);
    }

    @Override
    public ProjectDto toDto(Project entity) {
        MestoDto mesto = new MestoDto(entity.getMesto().getId(), entity.getMesto().getIme());
        
        MestoDto mestoInv = new MestoDto(entity.getInvestitor().getSrediste().getId(), entity.getInvestitor().getSrediste().getIme());
        
        InvestitorDto investitor = new InvestitorDto(entity.getInvestitor().getId(), entity.getInvestitor().getNaziv(), 
                entity.getInvestitor().getPib(), entity.getInvestitor().getMaticniBroj(), mestoInv);

        return new ProjectDto(entity.getId(), entity.getNaziv(), entity.getDatumPocetka(), entity.getDatumZavrsetka(), 
                mesto, investitor);
    }
    
}
