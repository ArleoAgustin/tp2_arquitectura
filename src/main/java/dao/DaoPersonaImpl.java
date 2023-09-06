package dao;

import connection.Singleton;
import dao.Interface.DaoPersona;
import entities.Persona;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoPersonaImpl  extends Conexion implements DaoPersona {

    private java.sql.Connection conection;
    private EntityManager entityManager;

    public DaoPersonaImpl(EntityManager em) throws Exception {
        this.conection = Singleton.getConnection();
        this.entityManager = em;
    }

    @Override
    public void addPersona(Persona p) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updatePersona(Persona p, Persona pNew) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(pNew);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletePersona(Long id) throws Exception {
        Persona p = obtenerPorId(id);
        if (p != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        }
    }

    public Persona obtenerPorId(Long id) {
        return entityManager.find(Persona.class, id);
    }

    @Override
    public List<Persona> getPersonas() throws Exception {
        List <Persona> query = entityManager.createQuery("SELECT p FROM Persona p").getResultList();
        return query;
    }
}
