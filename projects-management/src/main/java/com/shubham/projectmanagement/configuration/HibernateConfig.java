package com.shubham.projectmanagement.configuration;


import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;
import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.DRIVER;
import static org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO;
import static org.hibernate.cfg.AvailableSettings.SHOW_SQL;
import static org.hibernate.cfg.AvailableSettings.URL;
import static org.hibernate.cfg.AvailableSettings.USER;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shubham.projectmanagement.dto.Developer;
import com.shubham.projectmanagement.dto.Employee;
import com.shubham.projectmanagement.dto.EmployeeMeta;
import com.shubham.projectmanagement.dto.Project;
import com.shubham.projectmanagement.dto.Projects;
import com.shubham.projectmanagement.dto.ProjectsMeta;
import com.shubham.projectmanagement.dto.Task;

@Configuration
@PropertySource("classpath:dbc3p0.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.shubham.projectmanagement.dao"),
    @ComponentScan("com.shubham.projectmanagement.daoImpl") })
public class HibernateConfig {

  @Autowired
  private Environment env;

  @Bean
  public LocalSessionFactoryBean getSessionFactory() {
    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
    
    Properties props = new Properties();
    
    // Setting JDBC properties
    props.put(DRIVER, env.getProperty("mysql.driver"));
    props.put(URL, env.getProperty("mysql.jdbcUrl"));
    props.put(USER, env.getProperty("mysql.username"));
    //props.put(PASS, env.getProperty("mysql.password"));

    // Setting Hibernate properties
    props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
    props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));

    // Setting C3P0 properties
    props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
    props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
    props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
    props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
    props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

    factoryBean.setHibernateProperties(props);
    factoryBean.setAnnotatedClasses(Developer.class, Project.class, Task.class, Employee.class, EmployeeMeta.class, Projects.class, ProjectsMeta.class);
    
    return factoryBean;
  }

  @Bean
  public HibernateTransactionManager getTransactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(getSessionFactory().getObject());
    return transactionManager;
  }
   
 /**only for providing data source to spring security**/
  @Bean("dataSource")
  public DataSource getDataSource() {
     BasicDataSource dataSource = new BasicDataSource();
     dataSource.setDriverClassName(env.getProperty("mysql.driver"));
     dataSource.setUrl(env.getProperty("mysql.jdbcUrl"));
     dataSource.setUsername(env.getProperty("mysql.username"));
     dataSource.setPassword(env.getProperty("db.password"));
     return dataSource;
}
}