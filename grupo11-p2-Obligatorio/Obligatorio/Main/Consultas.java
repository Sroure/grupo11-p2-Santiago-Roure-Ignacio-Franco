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
            if (ListaTweets.get((long) i).getFechaTweet().contains(mes)){
                for (int j = 0; j < ListaPilotos.largo(); j++) {
                    // verifico si el tweet es de ese piloto
                        if (ListaTweets.get((long) i).getContent().contains(ListaPilotos.get(j).getNombre())) {
                            ListaPilotos.get(j).setCantidadMencion(ListaPilotos.get(j).getCantidadMencion() + 1);
                            mencionesPilotos.insert(ListaPilotos.get(j));
                            break;
                            // ahora lo que quiero es insertarlos en la lista menciones pilotos;
                        }
                        for (int x = 0; x < 10; x++) {
                            System.out.println(mencionesPilotos.getMax().getNombre());
                            mencionesPilotos.delete();
                        }

                }
            }
        }

    }
}


