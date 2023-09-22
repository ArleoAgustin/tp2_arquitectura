package percistence.entities;

import javax.persistence.*;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
@Table(name = "RelacionCarreraEstudiante", uniqueConstraints = @UniqueConstraint(columnNames = { "dni", "idCarrera" }))
public class RelacionCarreraEstudiante {

    @Id
    int id;
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



    //id,id_estudiante,id_carrera,inscripcion,graduacion,antiguedad
    public RelacionCarreraEstudiante(int id, Estudiante estudiante, Carrera carrera, LocalDateTime fechaDeInscripcion, LocalDateTime fechaDeEgreso) {
        this.id = id;
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaDeInscripcion = fechaDeInscripcion;
        this.fechaDeEgreso = fechaDeEgreso;
    }

    public int getId() {
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
