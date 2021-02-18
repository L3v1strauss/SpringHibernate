package com.springcource.hibernate_one_to_many;

import com.springcource.hibernate_one_to_many.entity.Department;
import com.springcource.hibernate_one_to_many.entity.Employee;
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
//            Department department = new Department("Sales", 10000, 1000);
//            Employee employee1 = new Employee("Jhoe", "Byden", 1500);
//            Employee employee2 = new Employee("Barak", "Obama",5000);
//            Employee employee3 = new Employee("Joerge", "Bush",5000);
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);
            currentSession.beginTransaction();
//            currentSession.save(department);
//            currentSession.delete(currentSession.get(Employee.class, 1));
            System.out.println("Get Department");
            Department department = currentSession.get(Department.class, 2);
            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Show employees of department");
            System.out.println(department.getEmployeeList());

            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
            assert currentSession != null;
            currentSession.close();
        }
    }
}
