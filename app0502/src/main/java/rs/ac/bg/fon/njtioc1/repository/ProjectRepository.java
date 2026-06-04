/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.repository;

import java.util.List;
import rs.ac.bg.fon.njtioc1.domain.Project;
import rs.ac.bg.fon.njtioc1.dto.ProjectDto;

/**
 *
 * @author student2
 */
public interface ProjectRepository {
    Project save(Project p);
    void delete(Project p);
    Project findById(Long id);
    void update(Project p);
    List<Project> findAll();
}
