package com.springcource.hibernate;

import com.springcource.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TestEmployee3 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            List<Employee> employeeList = currentSession.createQuery("from Employee")
                    .getResultList();
            for (Employee employee : employeeList) {
                System.out.println(employee);
            }
            List<Employee> employeeList2 = currentSession.createQuery("from Employee where name ='Lolita' ")
                    .getResultList();
            for (Employee employee : employeeList2) {
                System.out.println("---------------------");
                System.out.println(employee);
            }

            currentSession.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
