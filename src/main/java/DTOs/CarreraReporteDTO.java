package DTOs;
import java.util.TreeMap;

public class CarreraReporteDTO {


    public static final String SEPARADOR = "       ";
    private final String nombre;
    private TreeMap<Integer, EstudiantesPorAnioDTO> anios;

    public CarreraReporteDTO(String nombre) {
        this.nombre = nombre;
        this.anios = new TreeMap<>();
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
                SEPARADOR +
                nombre +
                ":"+'\n'+
                SEPARADOR +
                SEPARADOR +
                anios.values()+
                '\n';
    }
}
