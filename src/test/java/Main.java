import migration.ReadCSV;
import percistence.connection.EntityManager;
import percistence.connection.RepositoryFactory;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;
import percistence.repositories.Interface.InterfaceCarreraRepository;
import percistence.repositories.Interface.InterfaceEstudianteRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {

        Estudiante e1 = new Estudiante(41690992, "juan carlos", "maldacena", 22, "hombre", "tandil", 210203);
        Estudiante e2 = new Estudiante(41690993, "alfa", "romeo", 24, "hombre", "tandil", 2910321);
        Estudiante e3 = new Estudiante(41690994, "agustin", "carretero", 23, "mujer", "azul", 12321321);

        Carrera c1 = new Carrera("ingenieria de sistemas", 1);
        Carrera c2 = new Carrera("ingenieria en telecomunicaciones", 2);
        Carrera c3 = new Carrera("veterinaria", 3);


//se instancian los repositori's

        RepositoryFactory repositoryFactory = new RepositoryFactory();
        CarreraRepository carreraRepository = repositoryFactory.getInstanceCarreraRepository();
        EstudianteRepository estudianteRepository = repositoryFactory.getInstanceEstudianteRepository();


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
 */     System.out.println(carreraRepository.getReport());

        //System.out.println(carreraRepository.getCarreras());        obtiene todas las carreras
        //System.out.println(estudianteRepository.getEstudiantes());  obtiene todos los estudiantes

        EntityManager.closeEntityManager();
    }
}
