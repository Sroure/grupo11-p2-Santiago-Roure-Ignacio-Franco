package TADs.Stacks;

import TADs.Listas.ListasEnlazadas.ListaEnlazada;
import TADs.Listas.ListasEnlazadas.Nodo;

public class MainStack {
    public static void main(String[] args) {
        MyStack<Integer> Stack1 = new ListaEnlazada<>();
        Stack1.push(17);
        Stack1.push(999);
        Stack1.push(34);
        Stack1.push(7);
        Stack1.push(100);
        Stack1.mostrar();
        Nodo<Integer> N1 = Stack1.get(0);
        System.out.println("El primer elemento es: " + N1.datos);

    }
}
