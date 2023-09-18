import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;
import percistence.Interface.InterfaceCarreraRepository;
import percistence.Interface.InterfaceEstudianteRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {

        Estudiante e1 = new Estudiante(41690992L, "juan carlos", "maldacena", 22, "hombre", "tandil",210203);
        Estudiante e2 = new Estudiante(41690993L, "alfa", "romeo", 24, "hombre","tandil",2910321);
        Estudiante e3 = new Estudiante(41690994L, "agustin", "carretero", 23, "mujer","tandil",12321321);

        Carrera c1 = new Carrera("ingenieria de sistemas",1);
        Carrera c2 = new Carrera("ingenieria en telecomunicaciones",2);
        Carrera c3 = new Carrera("veterinaria",3);



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
        EntityManager em = emf.createEntityManager();

        InterfaceCarreraRepository carreraDao = new CarreraRepository(em);
        InterfaceEstudianteRepository estudianteDao = new EstudianteRepository(em);

        /*carreraDao.addCarrera(c1);
        carreraDao.addCarrera(c2);
        carreraDao.addCarrera(c3);

        estudianteDao.addEstudiante(e1);
        estudianteDao.addEstudiante(e2);
        estudianteDao.addEstudiante(e3);
*/


        /*carreraDao.matricularACarrera(e1, c2);
        estudianteDao.addEstudianteToCarrera(e1, c1);
        estudianteDao.addEstudianteToCarrera(e1, c3) ;
        estudianteDao.addEstudianteToCarrera(e2, c2);
        estudianteDao.addEstudianteToCarrera(e3, c3);*/


        System.out.println(carreraDao.getWithIscriptosOrderByCant());


        em.close();
        emf.close();
    }
}
