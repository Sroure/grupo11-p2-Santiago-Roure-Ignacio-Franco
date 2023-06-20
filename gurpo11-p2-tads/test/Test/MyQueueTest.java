package Test;

import LinkedList.ListaEnlazada;
import Queue.EmptyQueueException;
import Queue.MyQueue;
import org.junit.jupiter.api.Test;

class MyQueueTest {
    @Test
    void TestQueue() throws EmptyQueueException {
        // Pruebas de queue
        MyQueue queue = new ListaEnlazada();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.imprimirDatos();
        queue.dequeue();
        queue.imprimirDatos();
    }
}