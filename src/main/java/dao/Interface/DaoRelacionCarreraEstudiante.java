package dao.Interface;

import entities.Carrera;
import entities.Estudiante;

import java.util.List;

public interface DaoRelacionCarreraEstudiante {

    public void addRelacionCarreraEstudiante(Carrera c, Estudiante e) throws Exception;

    public void deleteRelacionCarreraEstudiante(Carrera c, Estudiante e) throws Exception;

    public List<Estudiante> getEstudiantesDe(Carrera c) throws Exception;

    public List<Carrera> getCarrerasDe(Estudiante e) throws Exception;

    public boolean existeRelacion(Carrera c, Estudiante e) throws Exception;
}
