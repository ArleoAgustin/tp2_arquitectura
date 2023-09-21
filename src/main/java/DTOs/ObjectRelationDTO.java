package DTOs;

import percistence.entities.Carrera;
import percistence.entities.Estudiante;
import percistence.entities.RelacionCarreraEstudiante;

public class ObjectRelationDTO {
    private Carrera carrera;
    private Estudiante estudiante;
    private RelacionCarreraEstudiante relacionCarreraEstudiante;
    private int fechaInscripcion;
    private int fechaEgreso;

    public ObjectRelationDTO(Carrera carrera, Estudiante estudiante, RelacionCarreraEstudiante relacionCarreraEstudiante) {
        this.carrera = carrera;
        this.estudiante = estudiante;
        this.relacionCarreraEstudiante = relacionCarreraEstudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public RelacionCarreraEstudiante getRelacionCarreraEstudiante() {
        return relacionCarreraEstudiante;
    }

}
