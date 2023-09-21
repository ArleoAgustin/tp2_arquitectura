package percistence.repositories;

import DTOs.CarreraEstudiante;
import DTOs.CarreraPorAnios;
import DTOs.EstudianteReporte;
import DTOs.ReporteDeCarreras;
import percistence.repositories.Interface.InterfaceCarreraRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;
import percistence.entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarreraRepository implements InterfaceCarreraRepository {

    private EntityManager entityManager;

    public CarreraRepository() throws Exception {
        this.entityManager = percistence.connection.EntityManager.getEntityManager();
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

    @Override
    public List<Carrera> getWithIscriptosOrderByCant() throws Exception {
        String jpql = "SELECT c " +
                "FROM Carrera c " +
                "WHERE SIZE(c.inscriptos) > 0 " +
                "ORDER BY SIZE(c.inscriptos) DESC";
        return this.entityManager.createQuery(jpql,Carrera.class).getResultList();
    }

    public ReporteDeCarreras getReport(){
        String jpql = "SELECT c, r, e " +
                "FROM Carrera c " +
                "INNER JOIN c.inscriptos r " +
                "INNER JOIN r.estudiante e";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();
        List<CarreraEstudiante> data = new ArrayList<>();
        for (Object[] resultado : resultados){
            data.add(new CarreraEstudiante((Carrera)resultado[0], (Estudiante)resultado[2], (RelacionCarreraEstudiante)resultado[1]));
        }
        HashMap<String, CarreraPorAnios> carreras = new HashMap<>();
        for (CarreraEstudiante carreraEstudiante : data) {
            String nombreCarrera = carreraEstudiante.getCarrera().getNombre();
            if(!carreras.containsKey(carreraEstudiante.getCarrera().getNombre())){
                carreras.put(nombreCarrera, new CarreraPorAnios(nombreCarrera));
            }
            carreras.get(nombreCarrera).addIngresante(new EstudianteReporte(carreraEstudiante.getEstudiante().getDni(), carreraEstudiante.getEstudiante().getNombre(), carreraEstudiante.getEstudiante().getApellido()) , carreraEstudiante.getRelacionCarreraEstudiante().getFechaDeInscripcion().getYear());
            if(carreraEstudiante.getRelacionCarreraEstudiante().getFechaDeEgreso() != null) {
                carreras.get(nombreCarrera).addEgresado(new EstudianteReporte(carreraEstudiante.getEstudiante().getDni(), carreraEstudiante.getEstudiante().getNombre(), carreraEstudiante.getEstudiante().getApellido()), carreraEstudiante.getRelacionCarreraEstudiante().getFechaDeEgreso().getYear());
            }
        }

        return new ReporteDeCarreras(new ArrayList<>(carreras.values()));
    }

}
