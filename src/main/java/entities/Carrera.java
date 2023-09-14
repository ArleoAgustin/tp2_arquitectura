package entities;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.util.List;
@Entity
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;
    @OneToMany(mappedBy = "carrera")
    private List<RelacionCarreraEstudiante> inscriptos;

    @Column(nullable = false, unique=true)
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

    public void matricularEstudiante(Estudiante e) {
        RelacionCarreraEstudiante inscripto = new RelacionCarreraEstudiante(this, e);
        this.inscriptos.add(inscripto);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String getEstudiantesInscriptos(){
        if(this.inscriptos == null || this.inscriptos.size() == 0) return "no hay inscritos";
        String estudiantes = "";
        for (RelacionCarreraEstudiante inscripto : inscriptos) {
            estudiantes += inscripto.getEstudiante().getApellido() + " " + inscripto.getEstudiante().getNombre() + ", ";
        }
        return estudiantes;
    }


    @Override
    public String toString() {
        return "Carrera{" +nombre +
                ", inscriptos = " + this.getEstudiantesInscriptos() +
                '}'+'\'';
    }
}
