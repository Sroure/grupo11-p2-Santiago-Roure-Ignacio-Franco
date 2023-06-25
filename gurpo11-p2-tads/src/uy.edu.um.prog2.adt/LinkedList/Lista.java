package LinkedList;

public interface Lista<T> {


    void agregar(T dato);
    void agregarAscendente(T dato);
    void addFirst(T value);
    void addLast(T value);
    void remove(int Position);
    T get(int Position);
    void imprimirDatos();
    void vaciarLista();
    int largo();



}
