package DTOs;

import java.util.ArrayList;
import java.util.List;

public class EstudiantesPorAnioDTO {

    private final int anio;
    private  List<EstudianteReporteDTO> inscriptos;
    private  List<EstudianteReporteDTO> egresados;



    public EstudiantesPorAnioDTO(int anio) {
        this.anio = anio;
        this.inscriptos = new ArrayList<>();
        this.egresados = new ArrayList<>();
    }

    public int getAnio() {
        return anio;
    }

    public List<EstudianteReporteDTO> getInscriptos() {
        return inscriptos;
    }

    public List<EstudianteReporteDTO> getEgresados() {
        return egresados;
    }

    public void addIscripto(EstudianteReporteDTO e) {
        inscriptos.add(e);
    }

    public void addEgresado(EstudianteReporteDTO e) {
        egresados.add(e);
    }

    @Override
    public String toString() {
        return
                ", inscriptos=" + inscriptos +
                ", egresados=" + egresados +
                '}'+'\n';
    }
}
