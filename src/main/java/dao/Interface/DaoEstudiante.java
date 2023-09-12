package dao.Interface;

import entities.Estudiante;

import java.util.List;

public interface DaoEstudiante {

    public void addEstudiante(Estudiante p) throws Exception;
    public void updateEstudiante(Estudiante p, Estudiante pNew) throws Exception;
    public void deleteEstudiante(Long id) throws Exception;
    public List<Estudiante> getEstudiantes() throws Exception;
}
