import dao.DaoCarreraImpl;
import dao.DaoEstudianteImpl;
import dao.DaoRelacionCarreraEstudianteImpl;
import dao.Interface.DaoCarrera;
import dao.Interface.DaoEstudiante;
import dao.Interface.DaoRelacionCarreraEstudiante;
import entities.Carrera;
import entities.Estudiante;
import entities.RelacionCarreraEstudiante;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {

        Estudiante e1 = new Estudiante(41690992L, "lucian", "bare", 22, "tandil");
        Estudiante e2 = new Estudiante(41690993L, "carl", "bare", 24, "tandil");
        Estudiante e3 = new Estudiante(41690994L, "agust", "carret", 23, "tandil");

        Carrera c1 = new Carrera("ingenieria de sistemas");
        Carrera c2 = new Carrera("ingenieria en PUTAS");
        Carrera c3 = new Carrera("veterinaria");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");
        EntityManager em = emf.createEntityManager();

        DaoCarrera carreraDao = new DaoCarreraImpl(em);
      /*  carreraDao.addCarrera(c1);
        carreraDao.addCarrera(c2);
        carreraDao.addCarrera(c3);
*/
        DaoEstudiante estudianteDao = new DaoEstudianteImpl(em);
        /*estudianteDao.addEstudiante(e1);
        estudianteDao.addEstudiante(e2);
        estudianteDao.addEstudiante(e3);
        estudianteDao.addEstudianteToCarrera(e1, c1);
        estudianteDao.addEstudianteToCarrera(e2, c2);
        estudianteDao.addEstudianteToCarrera(e3, c3);
        estudianteDao.addEstudianteToCarrera(e1, c3);*/


        System.out.println(e1.getCarrerasInscriptas());
        System.out.println(e2.getCarrerasInscriptas());
        System.out.println(e3.getCarrerasInscriptas());
        System.out.println(estudianteDao.getEstudiantes());
        System.out.println(carreraDao.getCarreras());

        em.close();
        emf.close();
    }
}
