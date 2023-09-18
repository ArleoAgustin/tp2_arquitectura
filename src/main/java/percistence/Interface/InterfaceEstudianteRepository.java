package percistence.Interface;

import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import java.util.List;

public interface InterfaceEstudianteRepository {

    public void addEstudiante(Estudiante p) throws Exception;
    public void updateEstudiante(Estudiante p, Estudiante pNew) throws Exception;
    public void deleteEstudiante(Long id) throws Exception;
    public List<Estudiante> getEstudiantes() throws Exception;

    public void addEstudianteToCarrera(Estudiante e, Carrera c) throws Exception;

    public List<Estudiante> buscarEstudiantesPorCarrera(Carrera c) throws Exception;

    List<Estudiante> getEstudiantesOrderByLastName() throws Exception;

    Estudiante getBy(int nroLibreta) throws Exception;

}
