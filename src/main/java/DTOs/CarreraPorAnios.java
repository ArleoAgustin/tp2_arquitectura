package DTOs;

import java.util.ArrayList;
import java.util.List;

public class CarreraPorAnios {

    private String nombre;
    private List<Anio> anios;

    public CarreraPorAnios(String nombre, List<Anio> anios) {
        this.nombre = nombre;
        this.anios = new ArrayList<>(anios);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Anio> getAnios() {
        return anios;
    }
}
