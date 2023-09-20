import percistence.connection.EntityManager;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;
import percistence.Interface.InterfaceCarreraRepository;
import percistence.Interface.InterfaceEstudianteRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {

//instancia estudiantes

        Estudiante e1 = new Estudiante(41690992L, "juan carlos", "maldacena", 22, "hombre", "tandil",210203);
        Estudiante e2 = new Estudiante(41690993L, "alfa", "romeo", 24, "hombre","tandil",2910321);
        Estudiante e3 = new Estudiante(41690994L, "agustin", "carretero", 23, "mujer","azul",12321321);
        Estudiante e4 = new Estudiante(41690995L, "roman", "elperi", 23, "mujer","azul",12321321);

//instancia carreras

        Carrera c1 = new Carrera("ingenieria de sistemas",1);
        Carrera c2 = new Carrera("ingenieria en telecomunicaciones",2);
        Carrera c3 = new Carrera("veterinaria",3);



//instancia repository's

        InterfaceCarreraRepository carreraRepository = new CarreraRepository();
        InterfaceEstudianteRepository estudianteRepository = new EstudianteRepository();

//agrega agrega las carreras
/*
        carreraRepository.addCarrera(c1);
        carreraRepository.addCarrera(c2);
        carreraRepository.addCarrera(c3);

//agrega los estudiantes

        estudianteRepository.addEstudiante(e1);
        estudianteRepository.addEstudiante(e2);
        estudianteRepository.addEstudiante(e3);
        estudianteRepository.addEstudiante(e4);
*/

/*
//matricula alumnos en una carrera

        carreraRepository.matricularACarrera(e4,c1);
        carreraRepository.matricularACarrera(e1, c2);
*/

//agrega estudiantes a carreras

/*      estudianteRepository.addEstudianteToCarrera(e1, c1);
        estudianteRepository.addEstudianteToCarrera(e1, c3) ;
        estudianteRepository.addEstudianteToCarrera(e2, c2);
        estudianteRepository.addEstudianteToCarrera(e3, c3);
 */

        System.out.println(carreraRepository.getCarreras());        //obtiene todas las carreras
        System.out.println(estudianteRepository.getEstudiantes());  //obtiene todos los estudiantes

    //    System.out.println(estudianteRepository.getAllBy("ingenieria de sistemas","tandil"));


//cierra la conexion
        EntityManager.closeEntityManager();
    }
}
