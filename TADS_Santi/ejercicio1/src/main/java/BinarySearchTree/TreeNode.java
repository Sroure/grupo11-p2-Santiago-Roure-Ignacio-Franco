package BinarySearchTree;

import LinkedList.Lista;
import Queue.MyQueue;
import com.sun.source.tree.Tree;


public class TreeNode<K extends Comparable<K>, T> {
    K key;
    T data;

    TreeNode<K, T> leftChild;
    TreeNode<K, T> rightChild;

    public TreeNode(K key, T data) {
        this.key = key;
        this.data = data;
    }

    // Metodo recursivo de add
    void add(K key, T data) {
        TreeNode<K, T> elementoNuevo = new TreeNode<>(key, data);

        if (key.compareTo(this.key)>0){ // aca el compare to se fija si el key es mayor a la raiz o en el nodo actual
            if (rightChild == null){// si no hay nada a la derecha
                rightChild = elementoNuevo;
            } else {
                rightChild.add(key, data); // si hay algo a la derecha se busca recursivamente hasta que no haya nada(null)
            }
        }else{// si el key es menor a la raiz o en el nodo actual
            if(leftChild == null){
                leftChild = elementoNuevo;
            }else{
                leftChild.add(key, data);
            }
        }

    }

    // metodo recursivo de delete
    public TreeNode<K,T> delete(K key){
        TreeNode<K,T> elementoARetornar = this;
        if (key.compareTo(this.key)>0) {

            if (rightChild != null) {
                rightChild = rightChild.delete(key);

            }
        }else if (key.compareTo(this.key)<0) {
                if (leftChild != null){
                    leftChild = leftChild.delete(key);
                }

        } else if (leftChild != null && rightChild != null) {
            // Encontre el elemento a eliminar
            TreeNode<K,T> minimo = rightChild.findmin();
            this.key = minimo.key;
            this.data = minimo.data;

            rightChild = rightChild.delete(minimo.getKey());

            } else {
                if (leftChild != null) {
                    elementoARetornar = leftChild;
                } else {
                    elementoARetornar = rightChild;
                }
            }
            return elementoARetornar;
        }



    // metodo recursivo de findmin
    public TreeNode<K,T> findmin(){
        if (leftChild != null){
            return leftChild.findmin();
        }else{
            return this;
        }
    }
    // metodo recursivo de size
    int size() {
        int largoizq = 0;
        int largoder = 0;
        if (this.leftChild != null) {
            largoizq = this.leftChild.size();
        }
        if (this.rightChild != null) {
            largoder = this.rightChild.size();
        }
        return 1 + largoizq + largoder;
    }

    public void inOrderTraversal(Lista traversal) {
        if (this.leftChild != null) {
            this.leftChild.inOrderTraversal(traversal);
        }
        traversal.agregar((Integer) this.data);
        if (this.rightChild != null) {
            this.rightChild.inOrderTraversal(traversal);
        }
    }

    public void imprimirArbol(){
        if (this.leftChild != null) {
            this.leftChild.imprimirArbol();
        }
        System.out.println(this.data);
        if (this.rightChild != null) {
            this.rightChild.imprimirArbol();
        }
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<K, T> rightChild) {
        this.rightChild = rightChild;
    }
}