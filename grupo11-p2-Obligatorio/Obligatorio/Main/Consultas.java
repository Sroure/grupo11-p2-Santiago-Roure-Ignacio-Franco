package Main;
import BinarySearchTree.BinarySearchTreeImpl;
import BinarySearchTree.MyTree;
import Entities.Piloto;
import Entities.Tweet;
import Entities.User;
import Hash.MyHash;
import Hash.MyHashImpl;
import Entities.HashTag;
import Heap.MyHeap;
import Heap.MyHeapImpl;
import LinkedList.Lista;

import static Main.MainMenu.CSVReader.ListaPilotos;
import static Main.MainMenu.CSVReader.ListaTweets;

public class Consultas {
    // (1) Primera consulta
    public static void ListarPilotosMasMencionados(String mes, MyHashImpl<Long, Tweet> ListaTweets, Lista<Piloto> ListaPilotos) {
        MyHeap<Piloto> mencionesPilotos = new MyHeapImpl<>(20);// quiero recorrer la lista de tweets y fijarme la cantidad de veces que aparece cada piloto en los tweets
        for (int i = 0; i < ListaTweets.elementosEnTabla(); i++) {// elementos en la talbla es el size
            Tweet tweet = ListaTweets.get((long) i);
            if (tweet != null && tweet.getFechaTweet().contains(mes)){
                System.out.println("Fecha del tweet: " + tweet.getFechaTweet() + " Contenido del tweet: " + tweet.getContent());
                for (int j = 0; j < ListaPilotos.largo(); j++) {
                    System.out.println("Buscando menciones del piloto: " + ListaPilotos.get(j).getNombre());
                    // verifico si el tweet es de ese piloto
                        if (tweet.getContent().contains(ListaPilotos.get(j).getNombre())) {
                            ListaPilotos.get(j).setCantidadMencion(ListaPilotos.get(j).getCantidadMencion() + 1);
                            mencionesPilotos.insert(ListaPilotos.get(j));// ahora lo que quiero es insertarlos en la lista menciones pilotos;
                            System.out.println("Piloto mencionado: " + ListaPilotos.get(j).getNombre() + " Cantidad de menciones: " + ListaPilotos.get(j).getCantidadMencion());
                            break;
                        }
                }
            }
        }// imprimir los 10 pilotos mas mencionados
        for (int x = 0; x < 10; x++) {
            System.out.println(mencionesPilotos.getMax().getNombre());
            mencionesPilotos.delete();
        }

    }
}


