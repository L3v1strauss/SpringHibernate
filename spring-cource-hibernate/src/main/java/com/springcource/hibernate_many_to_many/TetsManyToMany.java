package com.springcource.hibernate_many_to_many;

import com.springcource.hibernate_many_to_many.entity.Child;
import com.springcource.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TetsManyToMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
//            Section section1 = new Section("Karate");
////            Section section2 = new Section("Wrestling");
////            Section section3 = new Section("Muay-thai");
//            Child child1 = new Child("Steaven", 6);
//            Child child2 = new Child("Rose", 7);
//            Child child3 = new Child("Royce", 8);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
            session.beginTransaction();
//            session.persist(section1);
            session.delete(session.get(Section.class,7));
//            System.out.println(session.get(Section.class, 1));
//            System.out.println(session.get(Section.class,1).getChildrenList());
//            System.out.println(session.get(Child.class, 4));
//            System.out.println(session.get(Child.class, 4).getSectionList());
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
