package percistence.repositories.Interface;

import DTOs.ReporteDeCarreras;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import java.util.List;

public interface InterfaceCarreraRepository {

    void addCarrera(Carrera c) throws Exception;

    void deleteCarrera(Long id) throws Exception;

    Carrera getCarrera(Long id) throws Exception;

    void updateCarrera(Carrera c) throws Exception;

    List<Carrera> getCarreras() throws Exception;

    void matricularACarrera(Estudiante e, Carrera c) throws Exception;

    List getInscriptosA(Carrera c) throws Exception;

    List<Carrera> getWithIscriptosOrderByCant() throws Exception;

    /*ReporteDeCarreras getReport();*/

}
