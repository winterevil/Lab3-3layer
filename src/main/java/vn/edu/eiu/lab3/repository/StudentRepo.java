package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.Student;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class StudentRepo {
    //1. Create
    public static void add(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    //2. Read
    public static List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    //3. Update
    public static void edit(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    //4. Delete
    public static void remove(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Student std = em.find(Student.class, student.getId());
        if  (std != null) {
            em.remove(std);
        }
        em.getTransaction().commit();
        em.close();
    }
}
