package TADs.Queues;

import TADs.Listas.ListasEnlazadas.Nodo;

public interface MyQueue<T> {
    void enqueue(T value);
    Nodo<T> dequeue() throws EmpyQueueException;
    boolean contains(T datos);
    int size();
    void mostrar();
}
