package percistence.repositories;

import DTOs.Anio;
import DTOs.CarreraPorAnios;
import DTOs.EstudianteReporte;
import DTOs.ReporteDeCarreras;
import percistence.connection.Singleton;
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

    private java.sql.Connection conection;
    private EntityManager entityManager;

    public CarreraRepository(EntityManager em) throws Exception {
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

    @Override
    public List<Carrera> getWithIscriptosOrderByCant() throws Exception {
        String jpql = "SELECT c " +
                "FROM Carrera c " +
                "WHERE SIZE(c.inscriptos) > 0 " +
                "ORDER BY SIZE(c.inscriptos) DESC";
        return this.entityManager.createQuery(jpql,Carrera.class).getResultList();
    }

/*
    public ReporteDeCarreras getReport(){
        String jpql = "SELECT c.nombre, YEAR(e.fechaInscripcion), e, COUNT(e) " +
                "FROM Carrera c " +
                "JOIN c.estudiantes e " +
                "GROUP BY c.nombre, YEAR(e.fechaInscripcion)";

        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);

        List<Object[]> resultados = query.getResultList();

        Map<String, Map<Integer, Anio>> datosPorCarreraYAnio = new HashMap<>();

        for (Object[] resultado : resultados) {
            String nombreCarrera = (String) resultado[0];
            int annoInscripcion = (int) resultado[1];
            Estudiante estudiante = (Estudiante) resultado[2];
            long cantidadEstudiantes = (long) resultado[3];

            Map<Integer, Anio> aniosPorCarrera = datosPorCarreraYAnio.computeIfAbsent(nombreCarrera, k -> new HashMap<>());

            Anio anio = aniosPorCarrera.computeIfAbsent(annoInscripcion, k -> new Anio(annoInscripcion));

            if (estudiante.getCarrerasInscriptas()) {
                anio.addEgresado(new EstudianteReporte(estudiante.getDni(), estudiante.getNombre(), estudiante.getApellido()));
            } else {
                anio.addIscripto(new EstudianteReporte(estudiante.getDni(), estudiante.getNombre(), estudiante.getApellido()));
            }
        }


        List<CarreraPorAnios> carreras = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Anio>> entry : datosPorCarreraYAnio.entrySet()) {
            CarreraPorAnios carreraPorAnios = new CarreraPorAnios(entry.getKey(),new ArrayList<>(entry.getValue().values()));
            carreras.add(carreraPorAnios);
        }
        ReporteDeCarreras reporte = new ReporteDeCarreras(carreras);
        return reporte;
    }
*/

}
