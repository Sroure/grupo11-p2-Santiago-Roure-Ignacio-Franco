package TADs.Stacks;

import TADs.Listas.ListasEnlazadas.Nodo;

public interface MyStack<T> {
    void push(T datos);
    Nodo<T> pop() throws EmptyStackException;
    Nodo<T> peek();
    boolean contains(T value);
    Nodo<T> get(int i);
    int size();
    void mostrar();
}
