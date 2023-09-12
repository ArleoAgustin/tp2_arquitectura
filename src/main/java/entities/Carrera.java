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

    public Carrera(Long idCarrera, List<RelacionCarreraEstudiante> inscriptos, String nombre) {
        this.idCarrera = idCarrera;
        this.inscriptos = inscriptos;
        this.nombre = nombre;
    }

}
