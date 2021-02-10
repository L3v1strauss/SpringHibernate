package com.springcource.hibernate;

import com.springcource.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Employee employee = new Employee("Lolita", "Milavskaya", "IT", 500);
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.save(employee);
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
