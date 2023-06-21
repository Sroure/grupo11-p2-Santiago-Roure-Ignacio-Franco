package Test;

import LinkedList.ListaEnlazada;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {
    @Test
    void TestListaEnlazada(){
        // pruebas de linked list
        ListaEnlazada lista1 = new ListaEnlazada();
        lista1.agregar(1);
        lista1.agregar(2);
        lista1.agregar(3);
        lista1.agregar(4);
        lista1.imprimirDatos();
        assertEquals(4, lista1.largo());
        lista1.addFirst(0);
        lista1.imprimirDatos();
        assertEquals(5, lista1.largo());
        lista1.addLast(5);
        assertEquals(6, lista1.largo());
        lista1.remove(0);
        assertEquals(5, lista1.largo());
        lista1.imprimirDatos();


    }

}