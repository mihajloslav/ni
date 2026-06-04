/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package rs.ac.bg.fon.njtioc1.ditime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author student2
 */
@Component
public class DiTime {
    
    private DiTimeApp diTimeApp;
    @Autowired
    public DiTime(DiTimeApp diTimeApp) {
        this.diTimeApp = diTimeApp;
    }
    
    

    public static void main(String[] args) {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        DiTime app = ioc.getBean(DiTime.class);
        System.out.println("Trenutni datum:" + app.diTimeApp.vratiDatum());
    }
}
