package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    private Long dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;
    @Column
    private int edad;

    @Column
    private String ciudad;

    @Column(name = "nro_libreta")
    private String nroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private List<RelacionCarreraEstudiante> carrerasInscriptas;

    public Estudiante(Long dni, String nombre, String apellido, int edad, String ciudad) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public Estudiante() {}

    public Long getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(String nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public List<RelacionCarreraEstudiante> getCarrerasInscriptas() {
        return carrerasInscriptas;
    }

    public void setCarrerasInscriptas(List<RelacionCarreraEstudiante> carrerasInscriptas) {
        this.carrerasInscriptas = carrerasInscriptas;
    }
}
