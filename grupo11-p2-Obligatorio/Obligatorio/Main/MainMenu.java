package Main;
import Entities.Tweet;
import Entities.User;
import Hash.MyHash;
import Hash.MyHashImpl;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import LinkedList.Lista;
import LinkedList.ListaEnlazada;
import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class MainMenu {
    //*************************************** Menu Principal **************************************************
    public static void main(String[] args) {
        int option = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal");
            System.out.println("Seleccione una opcion");
            System.out.println("0- Cargar datos");
            System.out.println("1- Listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes");
            System.out.println("2- Top 15 usuarios con mas tweets");
            System.out.println("3- Cantidad de Hashtags distintos para un dia dado");
            System.out.println("4- Hashtag mas usado para un dia dado");
            System.out.println("5- Top 7 cuentas con mas favoritos");
            System.out.println("6- Cantidad de tweets con una palabra o frase especificos");
            System.out.println("7- Salir");
            System.out.println("Ingresar Numero: ");

            option = input.nextInt();
            input.nextLine();

            if (option >= 0 && option <= 7) {
                break; // Salir del bucle si el número está dentro del rango válido
            } else {
                System.out.println("Opcion invalida");
            }
        }

        switch (option) {
            case 0:
                CSVReader.CargaDeDatos();
                break;
            case 1:
                if (ingresoFecha() != 0) {

                } else {
                    break;
                }
            case 2:
                // Lógica para la opción 2
                break;
            case 3:
                // Lógica para la opción 3
                break;
            case 4:
                // Lógica para la opción 4
                break;
            case 5:
                // Lógica para la opción 5
                break;
            case 6:
                // Lógica para la opción 6
                break;
            case 7:
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }


}
    public static int ingresoFecha(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el año: ");
        int inputano = Integer.parseInt(input.nextLine());
        if (inputano == 2023){
            System.out.println("Ingrese el mes: ");
            int inputmes = Integer.parseInt(input.nextLine());
            if (inputmes < 13 && inputmes >0){
                return inputmes;
            }else{
                System.out.println("Mes invalido");
                System.exit(1);
            }
        }else{
            System.out.println("Año invalido");
            System.exit(1);
        }

   return 0;
    }

    //*************************************** Carga de datos del CSV **************************************************
    public class CSVReader {
        public static MyHash<Long,User> ListaUsuarios;
        public static Lista<Tweet> ListaTweets;
        public static Lista<String> ListaPilotos;
        public static void CargaDeDatos() {
            String csvFile = "C:/Users/santi/Downloads/archivosCSV/f1_dataset_test.csv";
            ListaUsuarios = new MyHashImpl<>(100000);// la lista de usuarios es un hash
            ListaTweets = new ListaEnlazada(); // la lista de tweets es una lista enlazada
            ListaPilotos = new ListaEnlazada(); // la lista de pilotos es una lista enlazada
            int cantidadTweets = 0;

            try (Reader reader = new FileReader(csvFile);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                for (CSVRecord csvRecord : csvParser) {
                    // Nombrar los campos del CSV //
                    String nombreUsuario = csvRecord.get(1);
                    String fechaTweet = csvRecord.get(9);
                    Long idTweet = crearid(fechaTweet); // creo un id a partir de la fecha con hashcode
                    String contenidoTweet = csvRecord.get(10);
                    String sourceTweet = csvRecord.get(12);
                    String usuarioFechaCreado = csvRecord.get(4);
                    Long idUsuario = crearid(usuarioFechaCreado); // creo un id a partir de la fecha con hashcode
                    boolean isretweet;
                    try {
                        isretweet = Boolean.parseBoolean(csvRecord.get(13));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    boolean usuarioVerificado;
                    try {
                        usuarioVerificado = Boolean.parseBoolean(csvRecord.get(8));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    // Realizar alguna operación con los datos

                    if (!ListaUsuarios.search(idUsuario)) { // Aqui verifico si el usuario esta o no en la lista y lo agrego
                        User nuevousuario = new User(idUsuario, nombreUsuario,usuarioVerificado);
                        ListaUsuarios.insert(idUsuario, nuevousuario);
                    }
                    Tweet nuevotweet = new Tweet(idTweet, contenidoTweet, sourceTweet,fechaTweet ,isretweet);
                    ListaTweets.addFirst(nuevotweet);
                    cantidadTweets++;

                }
                } catch(IOException e){
                    e.printStackTrace();
                }
//********************CargaNombresPilotostxt*************************
            try (FileReader fileReader = new FileReader("C:/Users/santi/Downloads/archivosCSV/drivers.txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    ListaPilotos.addFirst(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            }





    }

        public static Long crearid(String fecha) {
            int hash = fecha.hashCode();
            int hashAbs = Math.abs(hash);
            return (long) hashAbs;

        }
    }


