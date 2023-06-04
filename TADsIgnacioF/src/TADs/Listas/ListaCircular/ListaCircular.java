package TADs.Listas.ListaCircular;

public class ListaCircular {

    private Nodo head;
    private Nodo tail;

    private class Nodo {
        int valor;
        Nodo next;

        public Nodo(int valor) {
            this.valor = valor;
        }

        public Nodo(int valor, Nodo next) {
            this.valor = valor;
            this.next = next;
        }
    }

    public void agregarUltimo(int valor) {
        Nodo N1 = new Nodo(valor);
        if (head == null){
            head = N1;
            tail = N1;
        }
        else{
            tail.next = N1;
            N1.next = head;
            tail = N1;
        }
    }

    public Nodo eliminar(int valorx){
        Nodo temp = head;
        Nodo eli = null;

        if (temp.valor == valorx){
            eli = temp;
            head = head.next;
            tail.next = head;
        }
        do {
            Nodo p = temp.next;
            if (p.valor == valorx){
                temp.next = p.next;
                eli = p;
                break;
            }
            else {
                temp = temp.next;
            }
        }
        while (temp != head);
        if (eli == null){
            System.out.println("No se encontró el nodo a eliminar");
        }
        else{
            System.out.println("El valor del nodo eliminado fue: " + eli.valor);
        }
        return eli;
    }

    public void mostrar(){
        Nodo temp = head;
        if (head != null){
            do {
                System.out.print(temp.valor + " -> ");
                temp = temp.next;
            }
            while (temp !=head);
        }
        System.out.println(temp.valor);
    }
}

