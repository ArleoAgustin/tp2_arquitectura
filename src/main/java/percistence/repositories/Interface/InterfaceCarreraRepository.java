package percistence.repositories.Interface;

import DTOs.ReporteDeCarrerasDTO;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import java.util.List;

public interface InterfaceCarreraRepository {

    void addCarrera(Carrera c) throws Exception;

    void deleteCarrera(int id) throws Exception;

    Carrera getCarrera(int id) throws Exception;

    void updateCarrera(Carrera c) throws Exception;

    List<Carrera> getCarreras() throws Exception;

    void matricularACarrera(Estudiante e, Carrera c) throws Exception;

    List getInscriptosA(Carrera c) throws Exception;

    List<Carrera> getWithIscriptosOrderByCant() throws Exception;

    ReporteDeCarrerasDTO getReport();

}
