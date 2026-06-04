/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.config;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import rs.ac.bg.fon.njtioc1.repository.ProjectRepository;
import rs.ac.bg.fon.njtioc1.service.ProjectService;
import rs.ac.bg.fon.njtioc1.service.impl.ProjectServiceImpl;

/**
 *
 * @author student2
 */
//@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = {"rs.ac.bg.fon.njtioc1"})
public class AppConfig {
    /*@Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;*/
    
    @Bean
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/njt1klk1","root","");
    }
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:mysql://localhost:3306/njt1klk1");
        datasource.setUsername("root");
        datasource.setPassword("");
        return datasource;
    }
    
    
    
    @Bean(value="emf")
    public EntityManagerFactory getEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("rs.ac.bg.fon_NjtIoC1_jar_1.0-SNAPSHOTPU");
    
    }
    @Bean(value="sf")
    public SessionFactory getSessionFactory(){
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    
    
    
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    //-------------------------------------
    @Bean(value="serviceJPA")
    public ProjectService getJPAService(@Qualifier(value="repoJPA")ProjectRepository repository){
        return new ProjectServiceImpl(repository);
    }
    @Bean(value="serviceHibernate")
    public ProjectService getHibernateService(@Qualifier(value="repoHibernate")ProjectRepository repository){
        return new ProjectServiceImpl(repository);
    }
    
    
    
    
    @Bean(value="serviceJDBC")
    public ProjectService getJDCService(@Qualifier(value="repoJDBC")ProjectRepository repository){
        return new ProjectServiceImpl(repository);
    }
    @Bean(value="serviceSpringJDBC")
    public ProjectService getSpringJDBCService(@Qualifier(value="repoSpringJDBC")ProjectRepository repository){
        return new ProjectServiceImpl(repository);
    }
    
}
