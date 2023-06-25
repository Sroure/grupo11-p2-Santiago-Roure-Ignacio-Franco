package BinarySearchTree;
import LinkedList.Lista;

public interface MyTree <K ,T>{

    T find (K key);
    void add (K key, T data);
    void delete (K key);
    int size();
    int countLeaf();
    int countCompleteElements();
    void vaciarTree();

    Lista<T> inOrder();
    Lista<T> postorder();


}
