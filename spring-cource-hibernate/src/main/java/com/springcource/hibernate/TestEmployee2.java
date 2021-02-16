package com.springcource.hibernate;

import com.springcource.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmployee2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {
            Employee employee = new Employee("Stephan", "Rhyner", "Model", 9000);
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            currentSession.save(employee);
//            currentSession.getTransaction().commit();

            int myId = employee.getId();
//            currentSession = sessionFactory.getCurrentSession();
//            currentSession.beginTransaction();
            Employee employeeGenerated = currentSession.get(Employee.class, myId);
            currentSession.getTransaction().commit();
            System.out.println(employeeGenerated);

        } finally {
            sessionFactory.close();
        }
    }
}
