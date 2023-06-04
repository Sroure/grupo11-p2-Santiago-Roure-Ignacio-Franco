package TADs.Listas.ListaDoblementeEnlazada;

public class ListaDoblementeEnlazada {

    private Nodo head;

    private class Nodo {
        int valor;
        Nodo next;
        Nodo prev;

        public Nodo(int valor) {
            this.valor = valor;
        }

        public Nodo(int valor, Nodo next, Nodo prev) {
            this.valor = valor;
            this.next = next;
            this.prev = prev;
        }
    }

    public void agregarPrimero(int valor){
        Nodo N1 = new Nodo(valor);
        N1.next = head;
        N1.prev = null;
        if (head != null){
            head.prev = N1;
        }
        head = N1;
    }

    public void agregarUltimo(int valor){
        Nodo N1 = new Nodo(valor);
        Nodo temp = head;

        if (head == null){
            N1.prev = null;
            head = N1;
            return;
        }

        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = N1;
        N1.prev = temp;
        N1.next = null;
    }

    public Nodo encontrar(int valorx){
        Nodo N1 = head;
        while (N1 != null){
            if (N1.valor == valorx){
                return N1;
            }
            N1 = N1.next;
        }
        return null;
    }

    public void insertar(int afterValue, int valor){
        Nodo p = encontrar(afterValue);
        if (p == null){
            System.out.println("El nodo en el que se quiere insertar el nuevo valor, no está agregado");
        }
        else{
            Nodo N1 = new Nodo(valor);
            if (p.next == null) {
                agregarUltimo(valor);
            }
            else {
                N1.next = p.next;
                p.next.prev = N1;
                p.next = N1;
                N1.prev = p;
            }
        }
    }

    public void mostrar(){

        System.out.println("---------------------");
        System.out.println("Impresión en vista LIFO:");

        Nodo temp = head;
        Nodo ultimo = null;
        while (temp != null){
            if (temp.next != null){
                System.out.print(temp.valor + " -> ");
            }
            else {
                System.out.println(temp.valor);
            }
            ultimo = temp;
            temp = temp.next;
        }

        System.out.println("---------------------");
        System.out.println("Impresión en vista FIFO:");

        while (ultimo != null){
            if (ultimo.prev != null){
                System.out.print(ultimo.valor + " -> ");
            }
            else {
                System.out.println(ultimo.valor);
            }
            ultimo = ultimo.prev;
        }
    }




}
