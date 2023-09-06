import dao.DaoPersonaImpl;
import dao.Interface.DaoPersona;
import entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {

        Persona p1 = new Persona("Agustin", 23);
        Persona p2 = new Persona("Eusebio", 12);
        Persona p3 = new Persona("Margarito", 33);
        Persona p4 = new Persona("Claudio", 53);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Example");
        EntityManager em = emf.createEntityManager();

        DaoPersona personaDao = new DaoPersonaImpl(em);
        personaDao.addPersona(p1);
        personaDao.addPersona(p2);
        personaDao.addPersona(p3);
        personaDao.addPersona(p4);
        System.out.println(personaDao.getPersonas());
       //personaDao.deletePersona(L);
        System.out.println(personaDao.getPersonas());
       // personaDao.addPersona(p1);
       // System.out.println(personaDao.getPersonas());
        em.close();
        emf.close();
    }
}
