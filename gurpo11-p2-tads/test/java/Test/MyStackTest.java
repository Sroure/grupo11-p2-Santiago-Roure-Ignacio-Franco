package Test;
import LinkedList.ListaEnlazada;
import Stack.EmptyStackException;
import Stack.MyStack;
import org.junit.jupiter.api.Test;

class MyStackTest {
    @Test
    void TestStack() throws EmptyStackException {
        // Pruebas de stack
        MyStack stack = new ListaEnlazada();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.imprimirDatos();
        stack.pop();
        stack.imprimirDatos();
    }
}