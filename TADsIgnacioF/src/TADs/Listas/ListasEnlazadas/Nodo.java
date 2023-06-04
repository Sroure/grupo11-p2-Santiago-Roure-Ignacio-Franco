package TADs.Listas.ListasEnlazadas;

public class Nodo<T> {
    public T datos;
    public Nodo<T> next;

    public Nodo(T datos) {
        this.datos = datos;
    }

    public Nodo(T valor1, Nodo<T> próximo){
        this.datos = valor1;
        this.next = próximo;
    }

    public T getDatos() {
        return datos;
    }

    public Nodo<T> getNext() {
        return next;
    }
}
