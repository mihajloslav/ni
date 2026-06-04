/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.converter;

/**
 *
 * @author student2
 */
public interface Converter<Dto,Entity> {
    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
}
