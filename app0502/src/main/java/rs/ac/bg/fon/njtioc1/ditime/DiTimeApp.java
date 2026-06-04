/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.ditime;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

/**
 *
 * @author student2
 */
@Component
public class DiTimeApp {
    
    public LocalDate vratiDatum(){
        return LocalDate.now();
    }
}
