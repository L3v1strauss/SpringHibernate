package com.springcource.hibernate;

import com.springcource.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestUpdateObject {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Employee employee1 = currentSession.get(Employee.class, 1);
            employee1.setSalary(1000000);
            currentSession.createQuery("update Employee set salary = 8000 where name = 'Lolita'").executeUpdate();
//            Employee employee2 = currentSession.get(Employee.class, 4);
//            currentSession.delete(employee2);
            currentSession.createQuery("delete Employee where name = 'Stephany'" ).executeUpdate();
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
        }
    }