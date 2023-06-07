package LinkedList;
import Queue.MyQueue;
import Stack.MyStack;
import Stack.EmptyStackException;
import Queue.EmptyQueueException;


public class ListaEnlazada<T extends Comparable<T>> implements Lista<T>, MyStack<T>, MyQueue<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    int longitud;

    //@Override
    public ListaEnlazada() {
        this.primero = null;
    }

    public boolean esVacio() {
        if (this.primero == null) {
            return true;
        }

        return false;
    }

    public boolean buscar_elemento(T dato) {
        Nodo<T> nodoActual = primero;
        while (nodoActual != null) {
            if (nodoActual.getDato().equals(dato)) {
                return true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    @Override
    public void addFirst(T dato) {
        if (esVacio()) {
            primero = new Nodo<>(dato);
        } else {
            Nodo<T> nuevoNodo = new Nodo<>(dato);
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        }
    }

    @Override
    public void addLast(T dato) {
        Nodo<T> newNodo = new Nodo<>(dato);
        if (esVacio()) {
            primero = newNodo;
        } else {
            Nodo<T>nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {   // Lo que estamos haciendo aca es que empiezo a recorrer la lista enlazada
                nodoActual = nodoActual.getSiguiente();  // desde el primer nodo, por eso nodoActual = primero
            }
            nodoActual.setSiguiente(newNodo);       // lo que hago despues es fijarme si el siguiente es null o no(nodoActual.siguiente es igual a null?), en el caso de que sea null
            // decimos que el siguiente al nodoActual es el ultimo nodo, ya que es null, entonces ahi es cuando cambiamos el valor de null
            // por el valor del nodo que queremos agregar. Entonces queda agregado el nodo al final de la lista
        }
    }

    @Override
    public int largo() {
        Nodo<T> nodoActual;
        nodoActual = primero;
        int count = 0;
        if (nodoActual == null) {
            System.out.println("El largo de la lista es " + count);
        } else {
            count = 1;
            while (nodoActual != null) {
                nodoActual = nodoActual.getSiguiente();
                count++;
            }
            count = count - 1;
            System.out.println("El largo de la lista es " + count);
        }
        return count;
    }


    @Override
    public void agregar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
    }


    @Override
    public void remove(int Position) {
        if (Position < 0 || Position >= largo()) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        if (Position == 0) {
            primero = primero.getSiguiente();
            if (primero != null) {
                primero.setAnterior(null);
            }
        } else {
            Nodo<T> nodoActual = primero;
            int count = 0;
            while (count < Position - 1) {
                nodoActual = nodoActual.getSiguiente();
                count++;
            }
            nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente()); //lo que esta haciendo aqui es saltearse el nodo que queremos eliminar de manera que como no es referencia de otro
        }                                                          // nodo entonces no existe

    }

    @Override
    public T get(int Position) {
        return null;
    }

    @Override
    public void imprimirDatos() {
        Nodo<T> nodoActual= primero;
        while (nodoActual != null) {
            System.out.print(nodoActual.getDato() + " - ");
            nodoActual = nodoActual.getSiguiente();
        }
        System.out.println();
    }

    @Override
    public void vaciarLista() {
        primero = null;
    }

    //
    // Lista doblementeEnlazada
    //
    public void ListaDoblementeEnlazada(){
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }
    @Override
    public void agregarAscendente (T dato){// funcion que agrega datos de forma ascendente
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (primero == null) {//lista vacia
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else if (dato.compareTo(primero.getDato())<0){//el valor es menor que el primer elemento
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            primero = nuevoNodo;
        } else if (dato.compareTo(ultimo.getDato())>0){// el valor es mayor que el ultimo elemento
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        } else{
            Nodo<T> nodoActual = primero;
            while (nodoActual.getDato().compareTo(dato) < 0){
                nodoActual = nodoActual.getSiguiente();
            }
            Nodo<T> nodoAnterior = nodoActual.getAnterior();
            nuevoNodo.setSiguiente(nodoActual);
            nuevoNodo.setAnterior(nodoAnterior);
            nodoAnterior.setSiguiente(nuevoNodo);
            nodoActual.setAnterior(nuevoNodo);
        }
        longitud++;
    }

    //
    // Metodos especificos de Stack STACK
    //
    @Override
    public T pop() throws EmptyStackException {
        if(this.ultimo == null){ // si el stack es vacio entonces no hay nada que eliminar
            throw new EmptyStackException();
        }
        T valorEliminado = this.ultimo.getDato();
        this.ultimo = this.ultimo.getAnterior();
        this.longitud--;
        return valorEliminado;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (this.ultimo == null){
            throw new EmptyStackException();
        }else
            return this.ultimo.getDato();
    }

    @Override
    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.setSiguiente(this.ultimo);
        this.ultimo = nuevoNodo;
        this.longitud++;
    }

    public static boolean verificarEquilibrioSimb(String expresion) throws EmptyStackException {
        MyStack<Character> pila = new ListaEnlazada<>();
        for (int i = 0; i < expresion.length(); i++) {
            char simbolo = expresion.charAt(i);
            if (simbolo == '(' || simbolo == '[' || simbolo == '{') {
                pila.push(simbolo);
            } else if (simbolo == ')' || simbolo == ']' || simbolo == '}') {
                if (pila.esVacio()) {
                    return false;
                }
                char simboloTope = pila.peek();
                if (simbolo == ')' && simboloTope == '(' || simbolo == ']' && simboloTope == '[' || simbolo == '}' && simboloTope == '{') {
                    pila.pop();
                } else {
                    return false;
                }
            }
        }
        return pila.esVacio();
    }
    public static int evaluarPosfija(String expresionPosfija) {

        return 0;
    }

    //
    // Operaciones relacionadas con QUEUE
    //
    @Override
    public void enqueue(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (this.primero == null) {
            this.primero = nuevoNodo;
            this.ultimo = nuevoNodo;
        } else {
            this.ultimo.setSiguiente(nuevoNodo);
            this.ultimo = nuevoNodo;
            this.longitud++;
        }
    }
    @Override
    public T dequeue() throws EmptyQueueException {
        if (this.primero == null) {
            throw new EmptyQueueException();
        }
        T dato = this.primero.getDato();
        this.primero = this.primero.getSiguiente();
        this.longitud--;
        return dato;
    }


}