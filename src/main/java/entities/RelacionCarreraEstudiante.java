package entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RelacionCarreraEstudiante {

    @Id
    Long id;
    @ManyToOne
    @JoinColumn(name = "dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    private LocalDateTime fechaDeInscripcion;

    private LocalDateTime fechaDeEgreso;

    public RelacionCarreraEstudiante(Long id, Estudiante estudiante, Carrera carrera, LocalDateTime fechaDeInscripcion) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaDeInscripcion = fechaDeInscripcion;
    }

    public RelacionCarreraEstudiante(){}

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

    public void setFechaDeEgreso(LocalDateTime fechaDeEgreso) {
        this.fechaDeEgreso = fechaDeEgreso;
    }
}
