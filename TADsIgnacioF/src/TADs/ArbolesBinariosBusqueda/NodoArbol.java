package TADs.ArbolesBinariosBusqueda;

public class NodoArbol<K extends Comparable<K>, D>{
    private K key;
    private D datos;
    private NodoArbol<K,D> left;
    private NodoArbol<K,D> right;

    public NodoArbol(K key, D datos) {
        this.key = key;
        this.datos = datos;
    }

    public K getKey() {
        return key;
    }

    public D getDatos() {
        return datos;
    }

    public NodoArbol<K, D> getLeft() {
        return left;
    }

    public NodoArbol<K, D> getRight() {
        return right;
    }

    public void setLeft(NodoArbol<K, D> left) {
        this.left = left;
    }

    public void setRight(NodoArbol<K, D> right) {
        this.right = right;
    }

    public void add(K key, D datos){
        NodoArbol<K,D> N1 = new NodoArbol<>(key,datos);

        if (key.compareTo(this.key) > 0){
            if (right == null){
                right = N1;
            }
            else{
                right.add(key,datos);
            }
        }
        else {
            if (left == null){
                left = N1;
            }
            else{
                left.add(key,datos);
            }
        }
    }

    public NodoArbol<K,D> remove(K key){
        NodoArbol<K,D> elementToReturn = this;

        if (key.compareTo(this.key) > 0){
            if (right != null){
                right = right.remove(key);
            }
        }
        else if (key.compareTo(this.key) < 0){
            if (left != null){
                left = left.remove(key);
            }
        }

        // Si entra en cualquiera de los siguientes if, es porque
        // (key.compareTo(this.key) == 0, es decir se encontró
        // el nodo con la key a remover que es la que se pasó como parámetro.
        // Entonces, puede suceder que el nodo tenga 2 hijos, 1 hijo o 0 hijos

        else if (left != null && right != null){
            NodoArbol<K,D> NMin = right.findMin();
            this.key = NMin.getKey();
            this.datos = NMin.getDatos();

            right = right.remove(NMin.getKey());
        }
        else {
            if (left != null){
                elementToReturn = left;
            }
            if (right != null){
                elementToReturn = right;
            }
        }
        return elementToReturn;
    }

    public NodoArbol<K,D> findMin(){
        NodoArbol<K,D> NMin = this;
        if (left != null){
            NMin = left.findMin();
        }
        return NMin;
    }
}
