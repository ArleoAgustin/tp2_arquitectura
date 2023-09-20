package percistence.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {

    private static final EntityManagerFactory emf;
    private static final javax.persistence.EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("tp2");
        em = emf.createEntityManager();
    }

    private EntityManager() {}

    public static javax.persistence.EntityManager getEntityManager() {
        return em;
    }

    public static void closeEntityManager() {
        em.close();
        emf.close();
    }
}
