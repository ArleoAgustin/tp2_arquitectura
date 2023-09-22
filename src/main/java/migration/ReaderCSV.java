package migration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import percistence.connection.RepositoryFactory;
import percistence.entities.Carrera;
import percistence.entities.Estudiante;
import percistence.entities.RelacionCarreraEstudiante;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

        for(CSVRecord row: parser) {//id,id_estudiante,id_carrera,inscripcion,graduacion,antiguedad
            Carrera c = carreraRepository.getCarrera(Integer.parseInt(row.get("id_carrera")));
            Estudiante e = estudianteRepository.obtenerPorId(Integer.parseInt(row.get("id_estudiante")));
            RelacionCarreraEstudiante rce = new RelacionCarreraEstudiante(Integer.parseInt(row.get("id")), e, c, LocalDateTime.of(Integer.parseInt(row.get("inscripcion")), 1, 1, 1, 1), LocalDateTime.of(Integer.parseInt(row.get("graduacion")), 1, 1, 1, 1));
            estudianteRepository.addEstudianteToCarrera(rce);

        }
    }
}
