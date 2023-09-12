package dao.Interface;

import entities.Carrera;
import entities.Estudiante;

import java.util.List;

public interface DaoCarrera {

    public void addCarrera(Carrera c) throws Exception;
    public void deleteCarrera(Long id) throws Exception;
    public Carrera getCarrera(Long id) throws Exception;
    public void updateCarrera(Carrera c) throws Exception;
    public List<Carrera> getCarreras() throws Exception;

    public void addEstudianteToCarrera(Estudiante e, Carrera c) throws Exception;

    public List getInscriptosA(Carrera c) throws Exception;
}
