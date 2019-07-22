package com.stackroute;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.stackroute")
public class ConfigurationBean
{
    // Creating object for DriverManager and registering
    @Bean(name="dataSource")
    public DataSource dataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/stackroute");
        dataSource.setUsername("root");
        dataSource.setPassword("Root@123");
        return dataSource;
    }

    // DAO class object creation
    @Bean(name="EmployeeDao")
    public EmployeeDao EmployeeDao()
    {
        return new EmployeeDao();
    }

    public static class Employee {
    }
}