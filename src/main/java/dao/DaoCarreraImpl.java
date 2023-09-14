package dao;

import connection.Singleton;
import dao.Interface.DaoCarrera;
import entities.Carrera;
import entities.Estudiante;
import entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoCarreraImpl extends Conexion implements DaoCarrera {

    private java.sql.Connection conection;
    private EntityManager entityManager;

    public DaoCarreraImpl(EntityManager em) throws Exception {
        this.conection = Singleton.getConnection();
        this.entityManager = em;
    }

    @Override
    public void addCarrera(Carrera c) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteCarrera(Long id) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Carrera.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public Carrera getCarrera(Long id) throws Exception {
        return entityManager.find(Carrera.class, id);
    }

    @Override
    public void updateCarrera(Carrera c) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Carrera> getCarreras() throws Exception {
        entityManager.getTransaction().begin();
        List<Carrera> query = entityManager.createQuery("SELECT p FROM Carrera p").getResultList();
        entityManager.getTransaction().commit();
        return query;
    }

    @Override
    public void matricularACarrera(Estudiante e, Carrera c) throws Exception {
        RelacionCarreraEstudiante rce = new RelacionCarreraEstudiante(c, e);
        entityManager.getTransaction().begin();
        entityManager.persist(rce);
        entityManager.getTransaction().commit();
    }

    public List getInscriptosA(Carrera c) throws Exception{
        return this.entityManager.createQuery("SELECT r FROM RelacionCarreraEstudiante r WHERE r.carrera = " + c.getIdCarrera()).getResultList();
    }

}
