import migration.ReaderCSV;
import percistence.connection.EntityManager;
import percistence.connection.RepositoryFactory;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;

public class Main {

    public static void main(String[] args) throws Exception {

        RepositoryFactory repositoryFactory = new RepositoryFactory();
        CarreraRepository carreraRepository = repositoryFactory.getInstanceCarreraRepository();
        EstudianteRepository estudianteRepository = repositoryFactory.getInstanceEstudianteRepository();

        ReaderCSV readerCSV = new ReaderCSV();

        /*readerCSV.readDatesClientes();
        readerCSV.readDatesCarrera();
        readerCSV.readDatesEstudianteCarrera();*/

        /*Carrera tudai = carreraRepository.getCarrera(1);
        tudai.matricularEstudiante(estudianteRepository.obtenerPorId(1));
*/
        System.out.println(carreraRepository.getReport());
        System.out.println(estudianteRepository.getEstudiantes());
        System.out.println(carreraRepository.getCarreras());

        EntityManager.closeEntityManager();
    }
}
