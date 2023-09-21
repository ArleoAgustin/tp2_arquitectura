package DTOs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarreraPorAnios {

    private final String nombre;
    private HashMap<Integer, Anio> anios;

    public CarreraPorAnios(String nombre) {
        this.nombre = nombre;
        this.anios = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void addIngresante(EstudianteReporte estudianteReporte, Integer anio){
        if(!anios.containsKey(anio)){
            anios.put(anio, new Anio(anio));
        }
        anios.get(anio).addIscripto(estudianteReporte);
    }

    public void addEgresado(EstudianteReporte estudianteReporte, Integer anio){
        if(!anios.containsKey(anio)){
            anios.put(anio, new Anio(anio));
        }
        anios.get(anio).addEgresado(estudianteReporte);
    }

    @Override
    public String toString() {
        return
                "carrera= '" + nombre +"'"+
                ", " + anios +
                '}'+'\n';
    }
}
