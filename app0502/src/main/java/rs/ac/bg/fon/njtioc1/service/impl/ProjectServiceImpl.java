/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.bg.fon.njtioc1.converter.Converter;
import rs.ac.bg.fon.njtioc1.converter.impl.ConverterImpl;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.dto.ProjectDto;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectDoesNotExistException;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectExistException;
import rs.ac.bg.fon.njtioc1.service.ProjectService;
import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;
/**
 *
 * @author student2
 */
public class ProjectServiceImpl implements ProjectService{
    
    private ProjectRepository repository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }
    
    

    @Override
    public ProjectDto save(ProjectDto b) throws ProjectExistException {
        ConverterImpl conv = new ConverterImpl();
        
        
        
        Project temp = repository.findById(b.getId());
        //ProjectDto temp = conv.toDto(repository.findById(b.getId()));
        if(temp != null && temp.getNaziv().equals(b.getNaziv()))
            throw new ProjectExistException("Objekat već postoji!");
        
        
        repository.save((Project) new ConverterImpl().toEntity(b));
        return b;
    }

    @Override
    public void delete(ProjectDto b) throws ProjectDoesNotExistException {
        
        if(repository.findById(b.getId()) == null){
            throw new ProjectDoesNotExistException("Objekat ne postoji");
            
        }
        
        repository.delete((Project) new ConverterImpl().toEntity(b));
        
    }
    
    
    
    
    
    

    @Override
    public ProjectDto findById(Long id) {
        return new ConverterImpl().toDto(repository.findById(id));
    }

    @Override
    public void update(ProjectDto b) {
        repository.update((Project) new ConverterImpl().toEntity(b));
    }

    @Override
    public List<ProjectDto> findAll() {
        ConverterImpl conv = new ConverterImpl();
        return (List<ProjectDto>) repository.findAll().stream().map((x) -> conv.toDto(x)).toList();
    }
    
}
