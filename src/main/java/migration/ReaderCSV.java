package migration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import percistence.connection.RepositoryFactory;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;

import java.io.FileReader;

public class ReaderCSV {

    private String fileEstudiantes = "src/main/java/migration/CSVs/estudiantes.csv";
    private String fileEstudianteCarrera = "src/main/java/migration/CSVs/estudianteCarrera.csv";
    private String fileCarrera = "src/main/java/migration/CSVs/carreras.csv";

    private RepositoryFactory repositoryFactory = new RepositoryFactory();
    public void readDatesClientes() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantes));
        EstudianteRepository estudianteRepository = repositoryFactory.getInstanceEstudianteRepository();

        for(CSVRecord row: parser) {
            estudianteRepository.addEstudiante(new Estudiante(Integer.parseInt(row.get("DNI")), row.get("nombre"), row.get("apellido"), Integer.parseInt(row.get("edad")), row.get("genero"), row.get("ciudad"), Integer.parseInt(row.get("LU"))));
        }
    }

    public void readDatesCarrera() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileCarrera));
        CarreraRepository  carreraRepository = repositoryFactory.getInstanceCarreraRepository();

        for(CSVRecord row: parser) {
            carreraRepository.addCarrera(new Carrera(row.get("carrera"),Integer.parseInt(row.get("id_carrera"))));
        }
    }

    public void readDatesEstudianteCarrera() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudianteCarrera));
        EstudianteRepository  estudianteRepository = repositoryFactory.getInstanceEstudianteRepository();
        CarreraRepository  carreraRepository = repositoryFactory.getInstanceCarreraRepository();

        for(CSVRecord row: parser) {
           Carrera c =  carreraRepository.getCarrera(Integer.parseInt(row.get("id_carrera")));
           Estudiante e = estudianteRepository.obtenerPorId(Integer.parseInt(row.get("id_estudiante")));
           if(e!=null && c!=null) {
               e.addCarrera(c);
           }
        }
    }
}
