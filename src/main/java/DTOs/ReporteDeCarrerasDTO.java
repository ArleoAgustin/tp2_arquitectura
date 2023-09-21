package DTOs;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeCarrerasDTO {

    private List<CarreraReporteDTO> carreras;

    public ReporteDeCarrerasDTO(List<CarreraReporteDTO> carreras){
        this.carreras = new ArrayList<>(carreras);
    }

    public void addCarrera(List <CarreraReporteDTO> carreras){
        this.carreras.addAll(carreras);
    }


    @Override
    public String toString() {
        return "ReporteDeCarreras{" +
                " " + carreras +
                '}'+'\n';
    }
}
