package TADs.Listas.ListaDoblementeEnlazada;

import TADs.Listas.ListaDoblementeEnlazada.ListaDoblementeEnlazada;

public class MainListaDoblementeEnlazada {
    public static void main(String[] args) {
        ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada();
        lista1.agregarPrimero(17);
        lista1.agregarPrimero(34);
        lista1.agregarPrimero(87);
        lista1.agregarPrimero(10);
        lista1.agregarPrimero(7);
        lista1.agregarUltimo(100);
        lista1.insertar(1,5);
        lista1.mostrar();
    }
}
