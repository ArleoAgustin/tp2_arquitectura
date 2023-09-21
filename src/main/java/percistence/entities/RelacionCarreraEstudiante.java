package percistence.entities;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "RelacionCarreraEstudiante", uniqueConstraints = @UniqueConstraint(columnNames = { "dni", "idCarrera" }))
public class RelacionCarreraEstudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    private LocalDateTime fechaDeInscripcion;

    private LocalDateTime fechaDeEgreso;

    public RelacionCarreraEstudiante(){}

    public RelacionCarreraEstudiante(Carrera carrera, Estudiante estudiante) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaDeInscripcion = LocalDateTime.now();
        this.fechaDeEgreso = null;
    }

    public RelacionCarreraEstudiante(Long id, Estudiante estudiante, Carrera carrera, LocalDateTime fechaDeInscripcion) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public LocalDateTime getFechaDeInscripcion() {
        return fechaDeInscripcion;
    }

    public void setFechaDeInscripcion(LocalDateTime fechaDeInscripcion) {
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public LocalDateTime getFechaDeEgreso() {
        return fechaDeEgreso;
    }

    public void setFechaDeEgreso() {
        this.fechaDeEgreso = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return  "{carrera: "+carrera.getNombre() +
                " inscripto: " + estudiante.getNombre()  +
                " fechaDeInscripcion: " + fechaDeInscripcion +"}"+ "\n";
    }
}
