package TADs.Listas.ListaCircular;

import TADs.Listas.ListaCircular.ListaCircular;

public class MainListaCircular {
    public static void main(String[] args) {
        ListaCircular lista1 = new ListaCircular();
        lista1.agregarUltimo(17);
        lista1.agregarUltimo(82);
        lista1.agregarUltimo(99);
        lista1.agregarUltimo(100);
        lista1.agregarUltimo(5);
        lista1.mostrar();
        lista1.eliminar(99);
        lista1.mostrar();
        lista1.eliminar(17);
        lista1.mostrar();
    }
}
