package migration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;

public class ReaderCSV {

    private String fileEstudiantes = "src/main/java/migration/CSVs/estudiantes.csv";
    private String fileEstudianteCarrera = "src/main/java/migration/CSVs/estudainteCarrera.csv";
    private String fileCarrera = "src/main/java/migration/CSVs/estudiantes.csv";


    public void readDatesClientes() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantes));
        //aca guardamos al repository que nos da el factory para usar despues

        for(CSVRecord row: parser) {
            //aca se insertan los datos,
        }
    }
}
