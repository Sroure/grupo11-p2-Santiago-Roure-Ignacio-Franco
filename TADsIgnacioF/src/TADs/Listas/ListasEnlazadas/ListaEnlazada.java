package TADs.Listas.ListasEnlazadas;

import TADs.Queues.EmpyQueueException;
import TADs.Queues.MyQueue;
import TADs.Stacks.EmptyStackException;
import TADs.Stacks.MyStack;

public class ListaEnlazada<T> implements MyList<T>, MyStack<T>, MyQueue<T> {

    private Nodo<T>head;
    private Nodo<T> tail;

    public void addToBeginning(T valor) {
        Nodo<T> nodo = new Nodo<>(valor);
        nodo.next = head;
        head = nodo;

        if (tail == null){
            tail = head;
        }
    }

    public void addToEnd(T valor){
        if (tail == null){
            addToBeginning(valor);
            return;
        }
        Nodo<T> nodo = new Nodo<>(valor);
        tail.next = nodo;
        tail = nodo;
    }

    public void insert(T v, int i) { // siendo "v" el valor e "i" el índice
        if (i == 0) {
            addToBeginning(v);
        }
        if (i == this.size()) {
            addToEnd(v);
        }

        Nodo<T> temp = head;
        for (int j = 1; j < i; j++) {
            temp = temp.next;
        }

        Nodo<T> N1 = new Nodo<>(v,temp.next);
        temp.next = N1;
    }

    public Nodo<T> removeFirst(){
        Nodo<T> valorEliminado = head;
        head = head.next;
        if (head == null){
            tail = null;
        }

        return valorEliminado;
    }

    public Nodo<T> get(int i){ // siendo "i" un índice
        Nodo<T> N1 = head;
        for (int j = 0; j < i; j++) {
            N1 = N1.next;
        }
        return N1;
    }

    public Nodo<T> find(T valor_buscado){
        Nodo<T> NodoARegresar = new Nodo(0);
        Nodo<T> N1 = head;
        while (N1 != null){
            if (N1.datos == valor_buscado){
                NodoARegresar.datos = N1.datos;
                break;
            }
            N1 = N1.next;
        }
        return NodoARegresar;
    }

    public Nodo<T> removeLast(){
        if (this.size() <= 1){
            return removeFirst();
        }

        Nodo<T> NodoPenultimo = get(this.size() - 2);
        Nodo<T> NodoEliminado = tail;
        NodoPenultimo.next = null;
        tail = NodoPenultimo;

        return NodoEliminado;
    }

    public Nodo<T> removeP(int i){
        if (i == 0){
            return removeFirst();
        }
        if (i == (this.size() - 1)){
            return removeLast();
        }
        Nodo<T> NodoPrevio = get(i - 1);
        Nodo<T> NodoEliminado = NodoPrevio.next;
        NodoPrevio.next = NodoEliminado.next; // aca ya se está eliminando el valor
                                        // que estaba antes (se reemplaza)
        return NodoEliminado;
    }

    public void mostrar(){
        Nodo<T> temp = head;
        while (temp != null){
            if (temp.next != null){
                System.out.print(temp.datos + " - ");
            }
            else
                System.out.println(temp.datos);
            temp = temp.next;
        }
    }

    /* Métodos de Queue: */

    @Override
    public void enqueue(T datos) {
        addToEnd(datos);
    }

    @Override
    public Nodo<T> dequeue() throws EmpyQueueException {
        if (this.tail == null){
            throw new EmpyQueueException();
        }
        return removeFirst();
    }

    @Override
    public boolean contains(T value) {
        boolean contains = false;
        Nodo<T> temp = this.head;

        while (temp != null && (temp.datos != value)){
            temp = temp.next;
        }
        if (temp != null){
            contains = true;
        }
        return contains;
    }

    /* Métodos de Stack */

    @Override
    public void push(T value) {
        addToBeginning(value);
    }

    @Override
    public Nodo<T> pop() throws EmptyStackException {
        if (this.tail == null){
            throw new EmptyStackException();
        }
        return removeLast();
    }

    @Override
    public Nodo<T> peek() {
        Nodo<T> NodoARegresar = null;
        if(this.tail != null){
            NodoARegresar = this.tail;
        }
        return NodoARegresar;
    }

    @Override
    public int size() {
        int size = 0;
        Nodo<T> N1 = this.head;
        while (N1 != null){
            N1 = N1.next;
            size = size + 1;
        }

        return size;
    }
}