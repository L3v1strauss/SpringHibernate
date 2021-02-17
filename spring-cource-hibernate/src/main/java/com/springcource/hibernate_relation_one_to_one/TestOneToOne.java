package com.springcource.hibernate_relation_one_to_one;

import com.springcource.hibernate_relation_one_to_one.entity.Detail;
import com.springcource.hibernate_relation_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestOneToOne {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session currentSession = null;
        try {
            currentSession = sessionFactory.getCurrentSession();
            Employee employee = new Employee("Dzmitry","Borkunov","Actor", 10000);
            Detail detail = new Detail("Moscow", "123456978", "Borkunov@mail.ru");
            detail.setEmployee(employee);
            employee.setDetail(detail);
            currentSession.beginTransaction();
            currentSession.save(detail);
//            Detail detail = currentSession.get(Detail.class, 3);
//            System.out.println(employee.getDetail()); // получение деталей из связанной таблицы

//            currentSession.delete(detail); // удаление объекта
            currentSession.getTransaction().commit();
        } finally {
            sessionFactory.close();
            assert currentSession != null;
            currentSession.close();
        }
    }
}
