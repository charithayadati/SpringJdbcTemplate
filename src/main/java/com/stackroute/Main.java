package com.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String args[])
    {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(ConfigurationBean.class);
        EmployeeDao EmployeeDao=applicationContext.getBean("EmployeeDao",EmployeeDao.class);



        EmployeeDao.createTable();
        EmployeeDao.insertData();
        EmployeeDao.updateDetails();
        EmployeeDao.readData();


    }
}
