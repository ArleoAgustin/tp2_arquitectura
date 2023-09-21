package DTOs;

import percistence.entities.Carrera;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeCarreras {

    private List<CarreraPorAnios> carreras;

    public ReporteDeCarreras(List<CarreraPorAnios> carreras){
        this.carreras = new ArrayList<>(carreras);
    }

    public void addCarrera(List <CarreraPorAnios> carreras){
        this.carreras.addAll(carreras);
    }


    @Override
    public String toString() {
        return "ReporteDeCarreras{" +
                " " + carreras +
                '}'+'\n';
    }
}
