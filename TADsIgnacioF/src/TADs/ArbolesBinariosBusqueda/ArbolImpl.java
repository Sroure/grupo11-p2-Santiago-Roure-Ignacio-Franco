package TADs.ArbolesBinariosBusqueda;

public class ArbolImpl<K extends Comparable<K>,D> implements ArbolInterfaz<K,D> {
    private NodoArbol<K,D> root;

    @Override
    public void add(K key, D datos) {
        NodoArbol<K,D> N1 = new NodoArbol<>(key,datos);
        if (root == null){
            root = N1;
        }
        else {
            root.add(key,datos);
        }
    }

    @Override
    public void remove(K key) {
        if (root != null){
            root = root.remove(key);
        }
    }

    @Override
    public boolean contains(K key){
        return contains(key,root);
    }

    private boolean contains(K keyToSearch, NodoArbol<K,D> root) {
        boolean contains = false;

        if (root != null){
            int verificador = keyToSearch.compareTo(root.getKey());
            if (verificador == 0){
                contains = true;
            }
            else if (verificador > 0){
                contains = contains(keyToSearch,root.getRight());
            }
            else {
                contains = contains(keyToSearch,root.getLeft());
            }
        }
        return contains;
    }

    @Override
    public D find(K key) {
        return find(key,root);
    }

    private D find(K keyToSearch, NodoArbol<K,D> root){
        D datos = null;
        if (root != null){
            int verificador = keyToSearch.compareTo(root.getKey());
            if (verificador == 0){
                datos = root.getDatos();
            }
            else if (verificador > 0){
                datos = find(keyToSearch, root.getRight());
            }
            else  {
                datos = find(keyToSearch, root.getLeft());
            }
        }
        return datos;
    }
}
