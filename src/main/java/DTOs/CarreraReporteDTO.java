package DTOs;

import java.util.HashMap;

public class CarreraReporteDTO {

    private final String nombre;
    private HashMap<Integer, EstudiantesPorAnioDTO> anios;

    public CarreraReporteDTO(String nombre) {
        this.nombre = nombre;
        this.anios = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addIngresante(EstudianteReporteDTO estudianteReporteDTO, Integer anio){
        if(!anios.containsKey(anio)){
            anios.put(anio, new EstudiantesPorAnioDTO(anio));
        }
        anios.get(anio).addIscripto(estudianteReporteDTO);
    }

    public void addEgresado(EstudianteReporteDTO estudianteReporteDTO, Integer anio){
        if(!anios.containsKey(anio)){
            anios.put(anio, new EstudiantesPorAnioDTO(anio));
        }
        anios.get(anio).addEgresado(estudianteReporteDTO);
    }

    @Override
    public String toString() {
        return
                "carrera= '" + nombre +"'"+
                ", " + anios +
                '}'+'\n';
    }
}
