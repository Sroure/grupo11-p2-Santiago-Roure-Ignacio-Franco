package LinkedList;

public class Nodo<T> {
    private T dato;
    private Nodo<T> anterior;
    private Nodo<T> siguiente;

    public Nodo(T dato){
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;

    }

    public T getDato() {return dato;}

    public Nodo<T> getSiguiente(){return siguiente;}

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
}

