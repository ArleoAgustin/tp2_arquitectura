package DTOs;

public class EstudianteReporteDTO {

    String nombre;
    String apellido;
    int dni;

    public EstudianteReporteDTO(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return  nombre  +
                ", " + apellido + '\'' +
                ", dni=" + dni +
                '\n';
    }
}
