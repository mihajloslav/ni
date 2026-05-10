/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package rs.ac.bg.fon.app0502;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.app0502.config.AppConfig;
import rs.ac.bg.fon.app0502.dto.KatedraDto;
import rs.ac.bg.fon.app0502.dto.PredavacDto;
import rs.ac.bg.fon.app0502.dto.ZvanjeDto;
import rs.ac.bg.fon.app0502.service.PredavacService;

/**
 *
 * @author student2
 */


/*Kreirati model podataka koji će omogućiti čuvanje podataka o predavačima.
Za svakog predavača se čuva ime i prezime,
datum rodjenja, katedra kojoj pripada kao i zvanje.
Svaka katedra ima naziv i skraćeni naziv.
Zvanje koje predavač može da ima predstavlja šifarnik u kome se pored
naziva zvanja na srpskom čuva i zvanje na engleskom.


Kreirati repozitorijum za čuvanje predavača korišćenjem JPA,
Spring JDBC-a i Hibernate ORM.
(OVAJ PROJEKAT JE MALO MODIFIKOVAN TAKO DA KORISTI JDBC, JPA I SPRING JDBC)


Prilikom pokretanja programa, programu se prosleđuje parametar
1, 2 ili 3, 1 za čuvanje predavača preko JPa, 2 preko Spring JDBCa,
a 3 preko Hibernate ORMa.

Kreirati odgovarajuću servis klasu preko koje korisnik pristupa repozitorijumu podataka.

Aplikacija mora da koristi IoC i DI.*/
@Component
public class App0502 {
    private PredavacService predavacServiceJDBC;
    private PredavacService predavacServiceJPA;
    private PredavacService predavacServiceSpringJDBC;
    private PredavacService predavacServiceHibernate;

    @Autowired
    public App0502(@Qualifier(value = "predavacServiceJDBC")PredavacService predavacServiceJDBC, 
            @Qualifier(value = "predavacServiceJPA")PredavacService predavacServiceJPA, 
            @Qualifier(value = "predavacServiceSpringJDBC")PredavacService predavacServiceSpringJDBC,
            @Qualifier(value = "predavacServiceHibernate")PredavacService predavacServiceHibernate) {
        this.predavacServiceJDBC = predavacServiceJDBC;
        this.predavacServiceJPA = predavacServiceJPA;
        this.predavacServiceSpringJDBC = predavacServiceSpringJDBC;
        this.predavacServiceHibernate = predavacServiceHibernate;
    }
    
    public static void main(String[] args) {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        App0502 app = ioc.getBean(App0502.class);
        KatedraDto katedraDto = new KatedraDto(1L);
        ZvanjeDto zvanjeDto = new ZvanjeDto(2L);
        
        
        
        PredavacDto predavacDto = new PredavacDto("Marko", "Brankovic", LocalDate.of(1995, 1, 1), katedraDto, zvanjeDto);

        
        System.out.println("Unesite broj: 0, 1, 2\n\n0-JDBC\n1-JPA\n2-Spring JDBC\n3-Hibernate ORM\n\nUnos:");
        Scanner s = new Scanner(System.in);
        int broj;
        broj = s.nextInt();
        app.savePredavac(predavacDto, broj);
        //app.findAllPredavaci(broj);
    }

    private void savePredavac(PredavacDto predavacDto, int broj) {
        switch (broj) {
            case 0:
                predavacServiceJDBC.save(predavacDto);
                break;
            case 1:
                predavacServiceJPA.save(predavacDto);
                break;
            case 2:
                predavacServiceSpringJDBC.save(predavacDto);
                break;
            case 3:
                predavacServiceHibernate.save(predavacDto);
                break;
            default:
                System.out.println("UNELI STE LOŠ BROJ!!!");
        }
    }

    private void findPredavacById(Long id, int broj) {
        switch (broj) {
            case 0: {
                PredavacDto predavacDto = predavacServiceJDBC.findById(id);
                ispisiPredavca(predavacDto);
                break;
            }
            case 1: {
                PredavacDto predavacDto = predavacServiceJPA.findById(id);
                ispisiPredavca(predavacDto);
                break;
            }
            case 2: {
                PredavacDto predavacDto = predavacServiceSpringJDBC.findById(id);
                ispisiPredavca(predavacDto);
                break;
            }
            default:
                System.out.println("UNELI STE LOŠ BROJ!!!");
        }
    }

    private void findAllPredavaci(int broj) {
        switch (broj) {
            case 0: {
                List<PredavacDto> predavci = predavacServiceJDBC.findAll();
                ispisiPredavace(predavci);
                break;
            }
            case 1: {
                List<PredavacDto> predavci = predavacServiceJPA.findAll();
                ispisiPredavace(predavci);
                break;
            }
            case 2: {
                List<PredavacDto> predavci = predavacServiceSpringJDBC.findAll();
                ispisiPredavace(predavci);
                break;
            }
            default:
                System.out.println("UNELI STE LOŠ BROJ!!!");
        }
    }

    private void updatePredavac(PredavacDto predavacDto, int broj) {
        switch (broj) {
            case 0:
                predavacServiceJDBC.update(predavacDto);
                break;
            case 1:
                predavacServiceJPA.update(predavacDto);
                break;
            case 2:
                predavacServiceSpringJDBC.update(predavacDto);
                break;
            default:
                System.out.println("UNELI STE LOŠ BROJ!!!");
        }
    }

    private void deletePredavac(Long id, int broj) {
        switch (broj) {
            case 0:
                predavacServiceJDBC.delete(id);
                break;
            case 1:
                predavacServiceJPA.delete(id);
                break;
            case 2:
                predavacServiceSpringJDBC.delete(id);
                break;
            default:
                System.out.println("UNELI STE LOŠ BROJ!!!");
        }
    }

    private void ispisiPredavca(PredavacDto predavacDto) {
        if (predavacDto == null) {
            System.out.println("Predavac nije pronadjen!!!");
            return;
        }

        System.out.println(predavacDto);
    }

    private void ispisiPredavace(List<PredavacDto> predavci) {
        if (predavci == null || predavci.isEmpty()) {
            System.out.println("Nema predavaca u listi!!!");
            return;
        }

        for (PredavacDto predavacDto : predavci) {
            System.out.println(predavacDto);
        }
    }
}
