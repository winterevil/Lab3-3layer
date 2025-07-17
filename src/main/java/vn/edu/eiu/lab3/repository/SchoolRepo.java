package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.School;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class SchoolRepo {
    //1. Create
    public static void add(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
        em.close();
    }

    //2. Read
    public static List<School> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    //3. Update
    public static void edit(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
        em.close();
    }

    //4. Delete
    public static void remove(School school) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        School s = em.find(School.class, school.getSchoolId());
        if (s != null) {
            em.remove(s);
        }
        em.getTransaction().commit();
        em.close();
    }
}
