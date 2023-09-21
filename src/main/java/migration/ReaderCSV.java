package migration;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;

public class ReaderCSV {

    private String fileClientes = "src/main/java/migration/CSVs/clientes.csv";
    private String fileFacturas = "src/main/java/migration/CSVs/facturas.csv";
    private String fileProductos = "src/main/java/migration/CSVs/productos.csv";
    private String fileFacturas_Productos = "src/main/java/migration/CSVs/facturas-productos.csv";


    public void readDatesClientes() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileClientes));
        //aca guardamos al repository que nos da el factory para usar despues

        for(CSVRecord row: parser) {
            //aca se insertan los datos,
        }
    }
}
