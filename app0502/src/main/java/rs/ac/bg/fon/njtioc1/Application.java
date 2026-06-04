/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import rs.ac.bg.fon.njtioc1.config.AppConfig;
import rs.ac.bg.fon.njtioc1.domain.Investitor;
import rs.ac.bg.fon.njtioc1.dto.InvestitorDto;
import rs.ac.bg.fon.njtioc1.dto.MestoDto;
import rs.ac.bg.fon.njtioc1.dto.ProjectDto;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectDoesNotExistException;
import rs.ac.bg.fon.njtioc1.exceptions.ProjectExistException;
import rs.ac.bg.fon.njtioc1.service.ProjectService;

/**
 *
 * @author student2
 */
@Component
public class Application {

    private ProjectService serviceJPA;
    private ProjectService serviceHibernate;
    private ProjectService serviceJDBC;
    private ProjectService serviceSpringJDBC;

    
    
    public Application(@Qualifier(value = "serviceJPA") ProjectService serviceJPA,
            @Qualifier(value = "serviceHibernate") ProjectService serviceHibernate,
            @Qualifier(value = "serviceJDBC") ProjectService serviceJDBC,
            @Qualifier(value = "serviceSpringJDBC") ProjectService serviceSpringJDBC) {
        this.serviceJPA = serviceJPA;
        this.serviceHibernate = serviceHibernate;
        this.serviceJDBC = serviceJDBC;
        this.serviceSpringJDBC = serviceSpringJDBC;
    }

    public static void main(String[] args) throws ProjectExistException, ProjectDoesNotExistException {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = ioc.getBean(Application.class);

        MestoDto mestoDto1 = new MestoDto(1L, "Beograd");
        MestoDto mestoDto2 = new MestoDto(2L, "NoviSad");
        InvestitorDto invDto = new InvestitorDto(1L, "Investitor1", "pib1", "mat1", mestoDto2);
        ProjectDto projekat = new ProjectDto(1L, "Projekat1", LocalDate.of(2010, Month.MARCH, 1),
                LocalDate.of(2020, Month.MARCH, 1), mestoDto1, invDto);

        Scanner s = new Scanner(System.in);
        System.out.println("Izaberite operaciju:\n1 - save()\n2 - delete()\n3 - update()\n4 - findById()\n5 - findAll()");
        //System.out.println("Izaberite operaciju:\n1 - save()\n2 - delete()");

        System.out.print("Unesite izbor:");
        int operacija = s.nextInt();

        //System.out.println("Izaberite operaciju:\n1 - JPA\n2 - Hibernate\n");
        System.out.println("Izaberite operaciju:\n1 - JPA\n2 - Hibernate\n3 - JDBC\n4 - SpringJDBC");

        System.out.print("Unesite izbor:");
        int implementacija = s.nextInt();

        switch (operacija) {
            case 1:
                app.save(implementacija, projekat);
                break;
            case 2:
                app.delete(implementacija, projekat);
                break;
            case 3:
                app.update(implementacija, projekat);
                break;
            case 4:
                app.findById(implementacija, projekat.getId());
                break;
            case 5:
                app.findAll(implementacija);
                break;

            default:
                System.out.println("Uneli ste pogrešan broj za operaciju");

        }
    }

    private void save(int implementacija, ProjectDto p) throws ProjectExistException {
        switch (implementacija) {
            case 1:
                serviceJPA.save(p);
                break;
            case 2:
                serviceHibernate.save(p);
                break;
            case 3:
                serviceJDBC.save(p);
                break;
            case 4:
                serviceSpringJDBC.save(p);
                break;
            default:
                System.out.println("Uneli ste pogrešan broj za implementaciju");
        }

    }

    private void delete(int implementacija, ProjectDto p) throws ProjectDoesNotExistException {
        switch (implementacija) {
            case 1:
                serviceJPA.delete(p);
                break;
            case 2:
                serviceHibernate.delete(p);
                break;
            case 3:
                serviceJDBC.delete(p);
                break;
            case 4:
                serviceSpringJDBC.delete(p);
                break;
            default:
                System.out.println("Uneli ste pogrešan broj za implementaciju");
        }

    }

    private void update(int implementacija, ProjectDto p) {
        switch (implementacija) {
            case 1:
                serviceJPA.update(p);
                break;
            case 2:
                serviceHibernate.update(p);
                break;
            case 3:
                serviceJDBC.update(p);
                break;
            case 4:
                serviceSpringJDBC.update(p);
                break;
            default:
                System.out.println("Uneli ste pogrešan broj za implementaciju");
        }
    }

    private void findById(int implementacija, Long id) {
        switch (implementacija) {
            case 1:
                System.out.println(serviceJPA.findById(id));
                break;
            case 2:
                System.out.println(serviceHibernate.findById(id));
                break;
            case 3:
                System.out.println(serviceJDBC.findById(id));
                break;
            case 4:
                System.out.println(serviceSpringJDBC.findById(id));
                break;
            default:
                System.out.println("Uneli ste pogrešan broj za implementaciju");
        }
    }

    private void findAll(int implementacija) {
        switch (implementacija) {
            case 1:
                System.out.println(serviceJPA.findAll());
                break;
            case 2:
                System.out.println(serviceHibernate.findAll());
                break;
            case 3:
                System.out.println(serviceJDBC.findAll());
                break;
            case 4:
                System.out.println(serviceSpringJDBC.findAll());
                break;
            default:
                System.out.println("Uneli ste pogrešan broj za implementaciju");
        }
    }
}
