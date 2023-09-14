package dao;

import connection.Singleton;
import dao.Interface.DaoRelacionCarreraEstudiante;
import entities.Carrera;
import entities.Estudiante;
import entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoRelacionCarreraEstudianteImpl extends Conexion implements DaoRelacionCarreraEstudiante {

    private java.sql.Connection conection;
    private EntityManager entityManager;

    public DaoRelacionCarreraEstudianteImpl(EntityManager em) throws Exception {
        this.conection = Singleton.getConnection();
        this.entityManager = em;
    }


    @Override
    public void addRelacionCarreraEstudiante(Carrera c, Estudiante e) throws Exception {
        this.entityManager.getTransaction().begin();
        RelacionCarreraEstudiante r = new RelacionCarreraEstudiante(c, e);
        this.entityManager.persist(r);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public void deleteRelacionCarreraEstudiante(Carrera c, Estudiante e) throws Exception {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(new RelacionCarreraEstudiante(c, e));
        this.entityManager.getTransaction().commit();
    }

    @Override
    public List getEstudiantesDe(Carrera c) throws Exception {
        String query = "SELECT r.estudiante FROM RelacionCarreraEstudiante r WHERE r.carrera = " + c.getIdCarrera();
        return  this.entityManager.createQuery(query).getResultList();
    }

    @Override
    public List getCarrerasDe(Estudiante e) throws Exception {
        String query = "SELECT r.carrera FROM RelacionCarreraEstudiante r WHERE r.estudiante = " + e.getDni();
        return this.entityManager.createQuery(query).getResultList();
    }

    @Override
    public boolean existeRelacion(Carrera c, Estudiante e) throws Exception {
        return ((entityManager.createQuery("SELECT r FROM RelacionCarreraEstudiante r WHERE r.carrera = " + c.getIdCarrera() + " AND r.estudiante = " + e.getDni()).getResultList().size()) > 0);
    }
}
