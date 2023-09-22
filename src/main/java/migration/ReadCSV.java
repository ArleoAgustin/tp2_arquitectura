package migration;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import percistence.entities.Estudiante;
import percistence.repositories.CarreraRepository;
import percistence.repositories.EstudianteRepository;

import java.io.FileReader;

public class ReadCSV {

    private ReadCSV(){
        this.getInstance();
    }

    private String fileEstudiantes = "src/main/java/migration/CSVs/estudiantes.csv";
    private String fileEstudianteCarrera = "src/main/java/migration/CSVs/estudainteCarrera.csv";
    private String fileCarrera = "src/main/java/migration/CSVs/estudiantes.csv";

    private ReadCSV getInstance(){
        return new ReadCSV();
    }
/*
    public static void cargarDatos(EstudianteRepository er, CarreraRepository cr){
        for(CSVRecord row: parser) {

            new Estudiante(Integer.parseInt(row.get("DNI")),row.get("nombre"),row.get("apellido"),
                    Integer.parseInt(row.get("edad")), row.get("genero"), row.get("genero"),
                    Integer.parseInt( row.get("libreta")));
        }
    }
*/


    public static void readDatesEstudiantes() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileEstudiantes));

        for(CSVRecord row: parser) {

            new Cliente(Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email")));
        }
    }

    public void readDatesProductos() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileProductos));

        ProductoDAO product = factory.getProductoDAO();

        for(CSVRecord row: parser) {
            product.add(new Producto(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Double.parseDouble(row.get("valor"))));
        }
    }

    public void readDatesFacturas() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileFacturas));

        FacturaDAO factura = factory.getFacturaDAO();

        for(CSVRecord row: parser) {
            factura.add(new Factura(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente"))));
        }
    }

    public void readDatesFacturas_productos() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileFacturas_Productos));

        FacturaProductoDAO facProducto = factory.getFacturaProductoDAO();

        for(CSVRecord row: parser) {
            facProducto.add(new FacturaProducto(Integer.parseInt(row.get("idFactura")), Integer.parseInt(row.get("idProducto")), Integer.parseInt(row.get("cantidad"))));
        }
    }
}