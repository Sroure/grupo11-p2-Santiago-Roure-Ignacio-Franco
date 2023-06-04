package TADs.Queues;

import TADs.Listas.ListasEnlazadas.ListaEnlazada;

public class MainQueue {
    public static void main(String[] args) throws EmpyQueueException {
        MyQueue<Integer> Queue1 = new ListaEnlazada<>();
        Queue1.enqueue(17);
        Queue1.enqueue(900);
        Queue1.enqueue(550);
        Queue1.enqueue(5);
        Queue1.enqueue(3);
        Queue1.enqueue(100);
        Queue1.mostrar();
        Queue1.dequeue();
        Queue1.mostrar();
        System.out.println("El tamaño del stack es: " + Queue1.size());
        System.out.println("¿La Queque tiene el numero 17? " + Queue1.contains(17));
        System.out.println("¿La Queque tiene el numero 100? " + Queue1.contains(100));
    }
}
