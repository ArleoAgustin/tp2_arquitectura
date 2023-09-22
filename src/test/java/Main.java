import antlr.StringUtils;
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

        /*
        readerCSV.loadEstudiantes();
        readerCSV.loadCarreras();
        readerCSV.loadRelation();
*/
        System.out.println(carreraRepository.getReport());
       /* System.out.println(estudianteRepository.getEstudiantes());
        System.out.println(carreraRepository.getCarreras());*/

        EntityManager.closeEntityManager();
    }
}

/*reporte{
*           carrera: 2017{
*                           inscriptos :
*                           egresados :
*                    2018{
 *                           inscriptos :
 *                           egresados :
           carrera: 2016{
                             inscriptos :
                             egresados :
                    2017{
                             inscriptos :
                             *          fulanito de tal
                             egresados :
                             *          fulanito de tal
                             *          fulanito de tal
                             *          fulanito de tal
 *
 *
 *
 *
 * */
