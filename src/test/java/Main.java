import migration.ReaderCSV;
import percistence.connection.EntityManager;
import percistence.connection.RepositoryFactory;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;

public class Main {

    public static void main(String[] args) throws Exception {

        RepositoryFactory repositoryFactory = new RepositoryFactory();
        CarreraRepository carreraRepository = repositoryFactory.getInstanceCarreraRepository();
        EstudianteRepository estudianteRepository = repositoryFactory.getInstanceEstudianteRepository();

        ReaderCSV readerCSV = new ReaderCSV();


        readerCSV.loadEstudiantes();
        readerCSV.loadCarreras();
        readerCSV.loadRelation();


/*
        System.out.println(carreraRepository.getReport());
        System.out.println("");
        System.out.println("Estudiantes:");
        System.out.println();
        System.out.println(estudianteRepository.getEstudiantes());
        System.out.println("");
        System.out.println("Carreras:");
        System.out.println(carreraRepository.getCarreras());
*/

        EntityManager.closeEntityManager();
    }
}