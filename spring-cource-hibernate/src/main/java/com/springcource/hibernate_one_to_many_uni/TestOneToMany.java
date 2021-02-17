package com.springcource.hibernate_one_to_many_uni;

import com.springcource.hibernate_one_to_many_uni.entity.Department;
import com.springcource.hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session currentSession = null;
        try {
            currentSession = sessionFactory.getCurrentSession();
            Department department = new Department("IT", 10000, 1000);
            Employee employee1 = new Employee("Sarah", "Jessica-Parker", 1500);
            Employee employee2 = new Employee("Ann", "Hathaway",5000);
            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);


            currentSession.beginTransaction();
//            Employee employee = currentSession.get(Employee.class, 1);
            currentSession.save(department);
//            currentSession.delete(currentSession.get(Employee.class, 1));

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
            assert currentSession != null;
            currentSession.close();
        }
    }
}
