package BinarySearchTree;
import LinkedList.Lista;
import LinkedList.ListaEnlazada;
import LinkedList.Nodo;


public class BinarySearchTreeImpl<K extends Comparable<K>, T> implements MyTree<K,T>{

    private TreeNode <K,T>root;

    public BinarySearchTreeImpl() {
        this.root = null;
    }

    public TreeNode<K, T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<K, T> root) {
        this.root = root;
    }

    @Override
    public void add(K key, T data) {// insert de manera recursiva
        TreeNode<K,T> nuevoelemento = new TreeNode<>(key,data);
        if (this.root == null){
            this.root = nuevoelemento;
        }else{
            root.add(key,data); //Aca esta llamando al add de la clase TreeNode que es recursivo
        }
    }
    public void vaciarTree(){
        this.root = null;
    }

    @Override
    public void delete(K key) {
        if (this.root != null){
            this.root = this.root.delete(key);
        }
    }

    public T find(K key) {
        return find(key,root);
    }
    public T find(K keyAbuscar,TreeNode<K,T> root){
        T dato = null;
        if (root != null){
            int nValue = keyAbuscar.compareTo(root.getKey());
            if (nValue == 0){
                dato = root.getData();
            }else if (nValue > 0) { // como el compare to dio mayor a 0 significa que el key a buscar es mayor al key del root
                dato = find(keyAbuscar, root.getRightChild());//entonces me fijo en el hijo derecho
            }else {// el otro caso del compare to es que la key a buscar es mas chica que 0 entonces lo que hago es fijarme en el hijo izquierdo
                dato = find(keyAbuscar, root.getLeftChild());
            }
        }
    return dato;
    }
    public boolean contains(K key){
        return contains(key,root);
    }
    private boolean contains(K keyABuscar,TreeNode<K,T> root){
        boolean contains = false;
        if (root != null){
            int nValue = keyABuscar.compareTo(root.getKey());
            if (nValue == 0){
                contains = true;
            }else if (nValue > 0) {
                contains = contains(keyABuscar, root.getRightChild());
            }else {
                contains = contains(keyABuscar, root.getLeftChild());
            }
        }
        return contains;
    }


    @Override
    public int size() {// metodo recursivo de size lo llamo de la clase Node
        if (this.root != null)
            return this.root.size();
        return 0;
    }

    @Override
    public Lista<T> inOrder() {
        Lista<T> inOrderTraversal = new ListaEnlazada();
        if (this.root != null){
            this.root.inOrderTraversal(inOrderTraversal);
        }
        return inOrderTraversal;
    }
    @Override
    public Lista<T> postorder() {
        Lista<T> list = new ListaEnlazada();
        TreeNode<K,T> currentNode = this.root;
        while (currentNode != null){
            if (currentNode.rightChild == null){
                list.agregar(currentNode.data);
                currentNode = currentNode.leftChild;
            }else{
                TreeNode<K,T> sucesor = currentNode.rightChild;
                while (sucesor.leftChild != null && sucesor.leftChild != currentNode){
                    sucesor = sucesor.leftChild;
                }
                if (sucesor.leftChild == null){
                    sucesor.leftChild = currentNode;
                    currentNode = currentNode.rightChild;
                }else{
                    sucesor.leftChild = null;
                    list.agregar(currentNode.data);
                    currentNode = currentNode.leftChild;
                }
            }
        }

        return list;

    }


    @Override
    public int countLeaf() {

        return 0;
    }
    @Override
    public int countCompleteElements() {

        return 0;
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl binarySearchTreeImpl = new BinarySearchTreeImpl();

    }
}

//// metodos de Lista enlazada
