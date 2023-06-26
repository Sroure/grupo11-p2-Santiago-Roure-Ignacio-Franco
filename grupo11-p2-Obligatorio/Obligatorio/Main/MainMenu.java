package Main;
import BinarySearchTree.BinarySearchTreeImpl;
import BinarySearchTree.MyTree;
import Entities.HashTag;
import Entities.Piloto;
import Entities.Tweet;
import Entities.User;
import Hash.MyHash;
import Hash.MyHashImpl;
import Heap.MyHeap;
import Heap.MyHeapImpl;
import exceptions.ErrorAlCargarDatos;
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
import java.util.Hashtable;
import java.util.Scanner;
import static Main.MainMenu.CSVReader.*;

public class MainMenu {
    //*************************************** Menu Principal **************************************************
    public static void main(String[] args) {// menu principal
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
                switch (option) {
                    case 0:
                        CSVReader.CargaDeDatos();
                        System.out.println("Datos cargados correctamente");
                        break;
                    case 1:
                        CSVReader.ListarPilotosMasMencionados(ingresoFechames(), ingresoFechanio());
                        break;
                    case 2:
                        CSVReader.TopUsuariosMasTweets();
                        break;
                    case 3:
                        CSVReader.CantidadDeHashtagsDiaDado(ingresoFechaAniomesdia());
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
                        System.out.println("Saliendo del programa...\nGracias por usar el programa");
                        return; // Terminar la ejecución del programa
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } else {
                System.out.println("Opcion invalida");
            }
        }
    }

    public static String ingresoFechanio() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el año(yyyy): ");
        int inputano = Integer.parseInt(input.nextLine());
        if (inputano < 2023 && inputano >= 2020) {
            String inputanostring = Integer.toString(inputano);
            return inputanostring;
        } else {
            System.out.println("año invalido");
            System.exit(1);
        }
        return null;
    }

    public static String ingresoFechames() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Ingrese el mes(mm): ");
        int inputmes = Integer.parseInt(input1.nextLine());
        if (inputmes <= 12 && inputmes >= 1) {
            String inputmesstring = Integer.toString(inputmes);
            return inputmesstring;
        } else {
            System.out.println("mes invalido");
            System.exit(1);
        }
        return null;
    }

    public static String ingresoFechaAniomesdia() {
        Scanner input1 = new Scanner(System.in);
        System.out.println("Ingrese dia (yyyy-mm-dd): ");
        String inputaniomesdia = input1.nextLine();
        return null;
    }

    //*****************************************************************************************************************
    //*************************************** Carga de datos del CSV **************************************************
    //*****************************************************************************************************************
    public class CSVReader {
        public static MyHash<Integer, User> ListaUsuarios;
        public static MyHash<Integer, Tweet> ListaTweets;
        public static MyHash<Long, HashTag> ListaHashTags;
        public static Lista<Piloto> ListaPilotos;
        public static MyTree<Integer, Tweet> ListaTweetsordenada;

        public static void CargaDeDatos() {
            String csvFile = "C:/Users/santi/Downloads/archivosCSV/f1_dataset_test.csv";
            ListaUsuarios = new MyHashImpl<>(100000);// la lista de usuarios es un hash
            ListaTweets = new MyHashImpl<>(1000000); // la lista de tweets es una lista enlazada
            ListaPilotos = new ListaEnlazada<>(); // la lista de pilotos es una lista enlazada
            ListaHashTags = new MyHashImpl<>(1000000); // la lista de hashtags es un hash

            int cantidadUsuarios = 0;
            int cantidadTweets = 0;
            long contadorHashtagsDia = 0;


            try (Reader reader = new FileReader(csvFile);
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

                for (CSVRecord csvRecord : csvParser) {
                    // Nombrar los campos del CSV //
                    String nombreUsuario = csvRecord.get(1);
                    String fechaTweet = csvRecord.get(9);
                    int idTweet = crearid(fechaTweet); // creo un id a partir de la fecha con hashcode
                    String contenidoTweet = csvRecord.get(10);
                    String sourceTweet = csvRecord.get(12);
                    String usuarioFechaCreado = csvRecord.get(4);
                    int idUsuario = crearid(usuarioFechaCreado); // creo un id a partir de la fecha con hashcode
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
                    // Carga de HASHTAGS**********
                    String tempStr = csvRecord.get(11).replace("[", "").replace("]", "").replace("'", "").replace(" ", "");
                    String[] hashtags = tempStr.split(",");
                    System.out.println(hashtags.length);
                    for (String ht : hashtags) {
                        Long idHashTag = Long.valueOf(crearid(fechaTweet));
                        if (!ListaHashTags.search(idHashTag)) {
                            HashTag nuevoHashtag = new HashTag(idHashTag, ht);
                            ListaHashTags.insert(contadorHashtagsDia, nuevoHashtag);
                            contadorHashtagsDia++;
                        } else {
                            HashTag hashtagExistente = (HashTag) ListaHashTags.get(idHashTag);
                            for (int i = 0; i < hashtagExistente.getListaDeHashtag().ElementosEnhash(); i++) {
                                if (!hashtagExistente.getListaDeHashtag().search(ht)) {
                                    hashtagExistente.agregarHashtagAlista(ht);
                                }else{
                                    hashtagExistente.sumarCantidadHashtag(ht);
                                }
                            }
                        }
                        // Realizar alguna operación con los datos

                        if (!ListaUsuarios.search(idUsuario)) { // Aqui verifico si el usuario esta o no en la lista y lo agrego
                            User nuevousuario = new User(idUsuario, nombreUsuario, usuarioVerificado, usuarioFechaCreado);
                            cantidadUsuarios++;// pongo la cantidad de usuarios para poder iterar sobre el hash
                            ListaUsuarios.insert(cantidadUsuarios, nuevousuario);
                        } else {
                            User usuarioExistente = (User) ListaUsuarios.get(idUsuario);
                            usuarioExistente.incrementarCantidadTweets();
                        }

                        // Carga de TWEETS**********
                        Tweet nuevotweet = new Tweet(idTweet, contenidoTweet, sourceTweet, fechaTweet, isretweet, idUsuario);
                        cantidadTweets++;// pongo la cantidad de tweets para poder iterar sobre el hash
                        ListaTweets.insert(cantidadTweets, nuevotweet);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("EL tamaño de la lista de tweets es: " + cantidadTweets);
            System.out.println("EL tamaño de la lista de usuarios es: " + ListaUsuarios.ElementosEnhash());

//********************CargaNombresPilotostxt*************************
            try (FileReader fileReader = new FileReader("C:/Users/santi/Downloads/archivosCSV/drivers.txt");
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String nombre = line;
                    Piloto piloto = new Piloto(nombre);
                    ListaPilotos.agregar(piloto);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }// fin de la carga de datos


//********************************************************************************************************************
//******************************************* Consultas **************************************************************
//********************************************************************************************************************

        // (1) Primera consulta: Listar los 10 pilotos activos en la temporada 2023 mas mencionados en los tweets en un mes
        public static void ListarPilotosMasMencionados(String mes, String anio) {
            MyTree<Integer, Piloto> mencionesPilotos = new BinarySearchTreeImpl<>();// quiero recorrer la lista de tweets y fijarme la cantidad de veces que aparece cada piloto en los tweets
            System.out.println("Los 10 pilotos mas mencionados en el mes " + mes + " del año " + anio + " son: ");
            for (int i = 0; i < ListaTweets.ElementosEnhash(); i++) {// elementos en la talbla es el size
                Tweet tweet = ListaTweets.get(i);
                if (tweet != null) {
                    String fechaTweet = tweet.getFechaTweet();
                    if (fechaTweet.contains(anio) && fechaTweet.contains(mes)) {
                        for (int j = 0; j < ListaPilotos.largo(); j++) {
                            // verifico si el tweet es de ese piloto
                            if (tweet.getContent().contains(ListaPilotos.get(j).getNombre())) {// problema no me entra en el if
                                ListaPilotos.get(j).setCantidadMencion(ListaPilotos.get(j).getCantidadMencion() + 1);
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < ListaPilotos.largo(); j++) {
                mencionesPilotos.add(ListaPilotos.get(j).getCantidadMencion(), ListaPilotos.get(j));// ahora lo que quiero es insertarlos en la lista menciones pilotos;
            }

            // imprimir los 10 pilotos mas mencionados
            Lista lista = mencionesPilotos.postorder();
            for (int x = 0; x < 10; x++) {
                Piloto piloto = (Piloto) lista.get(x);
                System.out.println(piloto.getNombre() + " " + piloto.getCantidadMencion());
            }


        }

        ////////////////////////////
        //////////////////////////////
        public static void TopUsuariosMasTweets() {
            MyTree<Integer, User> top15usuarios = new BinarySearchTreeImpl<>();
            for (int i = 1; i < ListaUsuarios.ElementosEnhash(); i++) {
                User usuario = (User) ListaUsuarios.get(i);
                if (usuario != null) {
                    //int temp = contarCantidadTweetsUsuario(usuario);
                    //top15usuarios.add(usuario.getCantidadTweets(), usuario);
                    System.out.println("Usuario " + usuario.getName() + "con " + usuario.getCantidadTweets() + " tweets ");
                }
            }
            Lista lista = top15usuarios.postorder();
            System.out.println("definio la linked list");
            for (int j = 0; j < 15; j++) {
                System.out.println("entro en el for de 15");
                User usuario = (User) lista.get(j);
                System.out.println(" El usuario " + usuario.getName() + "que tiene" + usuario.getCantidadTweets() + "tweets " + " Verificado:" + usuario.isVerificado());
            }
        }

        public static int contarCantidadTweetsUsuario(User usuario) {
            for (int i = 0; i < ListaTweets.ElementosEnhash(); i++) {
                Tweet tweet = ListaTweets.get(i);
                if (tweet != null) {
                    int idUsuario = tweet.getIduser();
                    if (idUsuario == usuario.getId()) {
                        System.out.println("Incremento tweets usuario  " + idUsuario);
                        usuario.incrementarCantidadTweets();
                        System.out.println("Cantidad  " + usuario.getCantidadTweets());
                    }
                }
            }
            return usuario.getCantidadTweets();
        }

        public static void CantidadDeHashtagsDiaDado(String aniomesdia) {
            // buscar hashtags de ese dia

        }


// *********************************Getters y setters****************************************


        public static MyHash<Integer, User> getListaUsuarios() {
            return ListaUsuarios;
        }

        public static void setListaUsuarios(MyHash<Integer, User> listaUsuarios) {
            ListaUsuarios = listaUsuarios;
        }

        public static MyHash<Integer, Tweet> getListaTweets() {
            return ListaTweets;
        }

        public static void setListaTweets(MyHash<Integer, Tweet> listaTweets) {
            ListaTweets = listaTweets;
        }

        public static Lista<Piloto> getListaPilotos() {
            return ListaPilotos;
        }

        public static void setListaPilotos(Lista<Piloto> listaPilotos) {
            ListaPilotos = listaPilotos;
        }

//fin de la clase CSVReader


        public static Integer crearid(String fecha) {
            int hash = fecha.hashCode();
            int hashAbs = Math.abs(hash);
            return (int) hashAbs;


        }


    }//fin de la clase CSVReader
}//fin de la clase Main



