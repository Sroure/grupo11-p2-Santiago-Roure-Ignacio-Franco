package Main;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        System.out.println("Menu Principal");
        System.out.println("Seleccione una opcion");
        System.out.println("1- Listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes");
        System.out.println("2- Top 15 usuarios con mas tweets");
        System.out.println("3- Cantidad de Hashtags distintos para un dia dado");
        System.out.println("4- Hashtag mas usado para un dia dado");
        System.out.println("5- Top 7 cuentas con mas favoritos");
        System.out.println("6- Cantidad de tweets con una palabra o frase especificos");
        System.out.println("7- Salir");
        System.out.println("Ingresar Numero: ");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch (option){
            case 1:


            case 2:


            case 3:


            case 4:


            case 5:


            case 6:

            case 7:
                System.out.println("Saliendo del programa...");
                break;
        }


    }


    public class CSVReader {
        public static void main(String[] args) {
            String csvFile = "C:/Users/santi/Downloads/archivosCSV/f1_dataset.csv";

            try (Reader reader = new FileReader(csvFile);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                for (CSVRecord csvRecord : csvParser) {
                    // Acceder a los valores de cada columna por su índice o nombre
                    String columna1 = csvRecord.get(0);
                    String columna2 = csvRecord.get(1);
                    // Realizar alguna operación con los datos
                    System.out.println("Columna 1: " + columna1 + ", Columna 2: " + columna2);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
