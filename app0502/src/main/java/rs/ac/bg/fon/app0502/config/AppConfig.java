/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import rs.ac.bg.fon.app0502.repository.PredavacRepository;
import rs.ac.bg.fon.app0502.service.PredavacService;
import rs.ac.bg.fon.app0502.service.impl.PredavacServiceImpl;

/**
 *
 * @author student2
 */
@ComponentScan(basePackages = {"rs.ac.bg.fon.app0502"})
public class AppConfig {

    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/njt_priprema", "root", "");
    }

    @Bean(value = "emf")
    public EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("app0502PU");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost/njt_priprema");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;

    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean(value = "sf")
    public SessionFactory getSessionFactory(){
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    //---------------------------------------------------------------------

    @Bean(value = "predavacServiceJDBC")
    public PredavacService createPredavacServiceJDBC(@Qualifier(value = "predavacRepositoryJDBC") PredavacRepository predavacRepository) {
        return new PredavacServiceImpl(predavacRepository);
    }

    @Bean(value = "predavacServiceJPA")
    public PredavacService createPredavacServiceJPA(@Qualifier(value = "predavacRepositoryJPA") PredavacRepository predavacRepository) {
        return new PredavacServiceImpl(predavacRepository);
    }

    @Bean(value = "predavacServiceSpringJDBC")
    public PredavacService createPredavacServiceSpringJDBC(@Qualifier(value = "predavacRepositorySpringJDBC") PredavacRepository predavacRepository) {
        return new PredavacServiceImpl(predavacRepository);
    }
    @Bean(value = "predavacServiceHibernate")
    public PredavacService createPredavacServiceHibernate(@Qualifier(value ="predavacRepositoryHibernate") PredavacRepository predavacRepository){
        return new PredavacServiceImpl(predavacRepository);
    }
    
}
