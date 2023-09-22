package percistence.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    private int dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;
    @Column
    private int edad;

    @Column
    private String genero;


    @Column
    private String ciudad;

    @Column(name = "nro_libreta")
    private int nroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private List<RelacionCarreraEstudiante> carrerasInscriptas;

    public Estudiante() {}

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int nroLibreta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.nroLibreta = nroLibreta;
        this.genero = genero;
    }


    public int getDni() {
        return dni;
    }

    public String getGenero() {
        return genero;
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

    public int getNroLibreta() {
        return nroLibreta;
    }

    public void setNroLibreta(int nroLibreta) {
        this.nroLibreta = nroLibreta;
    }

    public List<RelacionCarreraEstudiante> getCarrerasInscriptas() {
        return carrerasInscriptas;
    }

    public void addCarrera(Carrera c) {
        RelacionCarreraEstudiante carreraInscripta = new RelacionCarreraEstudiante(c, this);
        this.carrerasInscriptas.add(carreraInscripta);
    }

    public void addCarrera(RelacionCarreraEstudiante carreraInscripta) {
        this.carrerasInscriptas.add(carreraInscripta);
    }

    public void setCarrerasInscriptas(List<RelacionCarreraEstudiante> carrerasInscriptas) {
        this.carrerasInscriptas = carrerasInscriptas;
    }

    private String obtenerListaCarreras() {
        String result = "";
        if(this.carrerasInscriptas != null) {
            for (RelacionCarreraEstudiante carrera : this.carrerasInscriptas) {
                result += carrera.getCarrera().getNombre() + ", ";
            }
            return result;
        } else {
            return "no hay inscriptos";
        }
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "dni= " + dni +
                ", nombre= " + nombre +
                ", apellido= " + apellido +
                ", edad= " + edad +
                ", genero= "+genero+
                ", ciudad= " + ciudad +
                ", nroLibreta= " + nroLibreta +
                ", carrerasInscriptas = " + this.obtenerListaCarreras() +
                '}'+'\n';
    }
}
