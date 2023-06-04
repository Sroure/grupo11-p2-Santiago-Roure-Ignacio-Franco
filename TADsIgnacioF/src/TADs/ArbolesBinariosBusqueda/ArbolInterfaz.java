package TADs.ArbolesBinariosBusqueda;

public interface ArbolInterfaz<K extends Comparable<K>,D> {
    void add(K key, D datos);
    void remove(K key);
    boolean contains(K key);
    D find(K key);

}
