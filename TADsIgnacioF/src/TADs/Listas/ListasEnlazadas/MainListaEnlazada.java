package TADs.Listas.ListasEnlazadas;

public class MainListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada<Integer> lista1 = new ListaEnlazada();
        lista1.addToBeginning(3);
        lista1.addToBeginning(4);
        lista1.addToBeginning(5);
        lista1.addToBeginning(6);
        lista1.addToBeginning(7);
        lista1.mostrar();
        lista1.addToEnd(99);
        lista1.mostrar();
        lista1.insert(100,3);
        lista1.mostrar();
        Nodo<Integer> eli = lista1.removeFirst();
        System.out.println("El número (nodo) eliminado fue: " + eli.datos);
        lista1.mostrar();
        Nodo<Integer> eli2 = lista1.removeLast();
        System.out.println("El numero eliminado (nodo) fue: " + eli2.datos);
        lista1.mostrar();
        Nodo<Integer> eli3 = lista1.removeP(2);
        System.out.println("El número eliminado (nodo) fue: " + eli3.datos);
        lista1.mostrar();
        Nodo <Integer> N1 = lista1.get(1);
        System.out.println("El número devuelto (datos del nodo) es: " + N1.datos);
        Nodo<Integer> N2 = lista1.find(4);
        System.out.println("Los datos del nodo devuelto son: " +  N2.datos);
        lista1.mostrar();
        System.out.println("El nodo cabeza sigue siendo: " + lista1.get(0).datos);
        System.out.println("El tamaño de la lista enlazada es: " + lista1.size());
        lista1.mostrar();
    }
}
