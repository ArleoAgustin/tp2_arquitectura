package dao;

import connection.Singleton;
import dao.Interface.DaoEstudiante;
import entities.Estudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoEstudianteImpl extends Conexion implements DaoEstudiante {

    private java.sql.Connection conection;
    private EntityManager entityManager;

    public DaoEstudianteImpl(EntityManager em) throws Exception {
        this.conection = Singleton.getConnection();
        this.entityManager = em;
    }

    @Override
    public void addEstudiante(Estudiante p) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateEstudiante(Estudiante p, Estudiante pNew) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(pNew);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteEstudiante(Long id) throws Exception {
        Estudiante p = obtenerPorId(id);
        if (p != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(p);
            entityManager.getTransaction().commit();
        }
    }

    public Estudiante obtenerPorId(Long id) {
        return entityManager.find(Estudiante.class, id);
    }

    @Override
    public List<Estudiante> getEstudiantes() throws Exception {
        List <Estudiante> query = entityManager.createQuery("SELECT p FROM Estudiante p").getResultList();
        return query;
    }
}
