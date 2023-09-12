package entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Carrera {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;
    @OneToMany(mappedBy = "carrera")
    private List<RelacionCarreraEstudiante> inscriptos;

    @Column(nullable = false)
    private String nombre;

    public Carrera(){}

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public Carrera(List<RelacionCarreraEstudiante> inscriptos, String nombre) {
        this.inscriptos = inscriptos;
        this.nombre = nombre;
    }

    public Long getIdCarrera() {
        return idCarrera;
    }

    public List<RelacionCarreraEstudiante> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(List<RelacionCarreraEstudiante> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public void addInscripto(RelacionCarreraEstudiante inscripto){
        this.inscriptos.add(inscripto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "idCarrera =" + idCarrera +
                ", inscriptos =" + inscriptos.toString() +
                ", nombre ='" + nombre + '\'' +
                '}';
    }
}
