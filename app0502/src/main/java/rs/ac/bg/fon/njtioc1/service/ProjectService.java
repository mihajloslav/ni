/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.service;

import java.util.List;
import rs.ac.bg.fon.njtioc1.dto.ProjectDto;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectDoesNotExistException;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectExistException;

/**
 *
 * @author student2
 */
public interface ProjectService {
    ProjectDto save(ProjectDto b) throws ProjectExistException;
    void delete(ProjectDto b) throws ProjectDoesNotExistException;
    ProjectDto findById(Long id);
    void update(ProjectDto b);
    List<ProjectDto> findAll();
}
