package vn.edu.eiu.lab3.repository;

import jakarta.persistence.EntityManager;
import vn.edu.eiu.lab3.entity.Major;
import vn.edu.eiu.lab3.infra.JpaUtil;

import java.util.List;

public class MajorRepo {
    //1. Create
    public static void add(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
        em.close();
    }

    //2. Read
    public static List<Major> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        return em.createQuery("SELECT m FROM Major m", Major.class).getResultList();
    }

    //3. Update
    public static void edit(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
        em.close();
    }

    //4. Delete
    public static void remove(Major major) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Major m = em.find(Major.class, major.getMajorId());
        if (m != null) {
            em.remove(m);
        }
        em.getTransaction().commit();
        em.close();
    }
}
