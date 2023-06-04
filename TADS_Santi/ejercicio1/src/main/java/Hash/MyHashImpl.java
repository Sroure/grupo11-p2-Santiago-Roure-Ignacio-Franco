package Hash;
import Hash.MyHash;
public class MyHashImpl<K,V> implements MyHash<K,V> {
    private Object[] hashTable;
    private int size;

    public MyHashImpl(int size) {
        if (size <=0) throw new IllegalArgumentException("Size tiene que ser mayor a 0");
        this.size = size;
        this.hashTable = new Object[size];
    }

    private int HashFunction(K key) {
        return key.hashCode() % size;
    }

    @Override
    public void insert(K key, V value) {
        int index = HashFunction(key);
        hashTable[index] = key;
        if (hashTable[index] == null) {
            hashTable[index] = value;
            size++;
        }
    }

    @Override
    public void delete(K key) {
        int index = HashFunction(key);
        if (hashTable[index] != null) {
            hashTable[index] = null;
            size--;
        }
    }

    @Override
    public V search(K key) {// este metodo lo que haces es que busca el elemento por la key y si lo encuentra devuelve true
        int index = HashFunction(key);
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null && hashTable[i].equals(key)) {
                return (V) hashTable[i];
            }
        }

    }
}
