package com.stackroute;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeDao {


    // Declaration
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public void createTable()
    {
        String query="create table employees(id int,name varchar(20),marks int,gender varchar(20))";
        jdbcTemplate.execute(query);
    }

    public void insertData()
    {
        String query="insert into employees values(33,'Surya',50,'male')";
        jdbcTemplate.execute(query);
    }

    // Implementing rowmapper
    public Employee readData()
    {
        String query="select * from employees";
        return jdbcTemplate.queryForObject(query, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
               Employee employee=new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setGender(resultSet.getString(4));
                employee.setAge(resultSet.getInt(3));
                return employee;
            }
        });
    }

    public void updateDetails()
    {
        String query="update employees set name='Vamsi' where id=33";
        jdbcTemplate.execute(query);
    }

    public void deleteDetails()
    {
        String query="delete from employees";
        jdbcTemplate.update(query);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
}

