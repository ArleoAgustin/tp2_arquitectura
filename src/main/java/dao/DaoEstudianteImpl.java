package dao;

import connection.Singleton;
import dao.Interface.DaoEstudiante;
import entities.Carrera;
import entities.Estudiante;
import entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public List getEstudiantes() throws Exception {
        return  entityManager.createQuery("SELECT p FROM Estudiante p").getResultList();
    }

    @Override
    public void addEstudianteToCarrera(Estudiante e, Carrera c) throws Exception {
        RelacionCarreraEstudiante rce = new RelacionCarreraEstudiante(c, e);
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(rce);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List<Estudiante> buscarEstudiantesPorCarrera(Carrera c) throws Exception {
        TypedQuery<Estudiante> query = this.entityManager.createQuery(
                "SELECT e FROM Estudiante e JOIN RelacionCarreraEstudiante r WHERE r.carrera.id = :c",
                Estudiante.class
        );
        query.setParameter("c", c.getIdCarrera());
        return query.getResultList();
    }

    public List getCarrerasIscriptas() {
        this.entityManager.getTransaction().begin();
        TypedQuery<Carrera> query = this.entityManager.createQuery(
                "SELECT DISTINCT r.carrera FROM RelacionCarreraEstudiante r",
                Carrera.class
        );
        return query.getResultList();
    }
}
