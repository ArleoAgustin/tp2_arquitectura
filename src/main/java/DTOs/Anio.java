package DTOs;

import percistence.entities.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Anio {

    private final int anio;
    private  List<EstudianteReporte> inscriptos;
    private  List<EstudianteReporte> egresados;

    public Anio(int anio){
        this.anio = anio;
    }

    public Anio(int anio, List<EstudianteReporte> inscriptos, List<EstudianteReporte> egresados) {
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public int getAnio() {
        return anio;
    }

    public List<EstudianteReporte> getInscriptos() {
        return inscriptos;
    }

    public List<EstudianteReporte> getEgresados() {
        return egresados;
    }

    public void addIscripto(EstudianteReporte e) {
        inscriptos.add(e);
    }

    public void addEgresado(EstudianteReporte e) {
        egresados.add(e);
    }


}
