package Hash;

public interface MyHash<K, V> {
    void insert(K key, V value);
    void delete(K key);
    boolean search(K key);
    V get(K key);
    int elementosEnTabla();


}
