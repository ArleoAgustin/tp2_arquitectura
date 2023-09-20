package percistence.repositories;

import percistence.Interface.InterfaceEstudianteRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;
import percistence.entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteRepository implements InterfaceEstudianteRepository {

    private EntityManager entityManager;

    public EstudianteRepository() throws Exception {
        this.entityManager = percistence.connection.EntityManager.getEntityManager();
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

    @Override
    public List<Estudiante> getEstudiantesOrderByLastName() throws Exception {
        return entityManager.createQuery("SELECT e FROM Estudiante e ORDER BY e.apellido ASC", Estudiante.class).getResultList();
    }

    @Override
    public Estudiante getBy(int nroLibreta) throws Exception {
        return this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.nroLibreta = :nroLibreta",
                Estudiante.class).setParameter("nroLibreta", nroLibreta).getSingleResult();
    }

    @Override
    public List getAllBy(String genero) throws Exception {
        return entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero").setParameter("genero", genero).getResultList();
    }

    @Override
    public List<Estudiante> getAllBy(String carrera, String ciudad) throws Exception {
        String jpql = "SELECT e " +
                "FROM Estudiante e " +
                "JOIN e.carrerasInscriptas c " +
                "WHERE c.carrera.nombre = :nombreCarrera " +
                "AND e.ciudad = :ciudad";
        TypedQuery<Estudiante> query =  this.entityManager.createQuery(jpql, Estudiante.class);
        query.setParameter("ciudad", ciudad);
        query.setParameter("nombreCarrera", carrera);
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
