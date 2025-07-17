package vn.edu.eiu.lab3.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;
    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-mysql-persistence");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private JpaUtil() {}

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
