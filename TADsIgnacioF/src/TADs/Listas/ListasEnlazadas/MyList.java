package TADs.Listas.ListasEnlazadas;

public interface MyList<T> {
    void addToBeginning(T valor);
    void addToEnd(T valor);
    void insert(T v, int i);
    Nodo<T> removeFirst();
    Nodo<T> get(int i);
    Nodo<T> find(T valorx);
    Nodo<T> removeLast();
    Nodo<T> removeP(int i);
    int size();
    void mostrar();
}
