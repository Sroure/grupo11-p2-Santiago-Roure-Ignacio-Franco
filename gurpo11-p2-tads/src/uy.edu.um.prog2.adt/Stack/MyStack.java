package Stack;

public interface MyStack <T> {
    T pop () throws EmptyStackException;
    T peek() throws EmptyStackException;
    boolean esVacio ();
    void vaciarLista();
    void push(T dato);
    int largo();
    void imprimirDatos();
}
