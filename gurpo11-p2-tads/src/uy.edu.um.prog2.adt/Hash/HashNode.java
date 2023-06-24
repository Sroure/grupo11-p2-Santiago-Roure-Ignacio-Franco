package Hash;

import java.util.Objects;

public class HashNode<K,V> {
    private K key;
    private V value;
    boolean deleted = false;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    public boolean isDeleted(){
        return deleted;
    }
    public void setDeleted(boolean deleted){
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashNode<?, ?> hashNode = (HashNode<?, ?>) o;
        return Objects.equals(key, hashNode.key) && Objects.equals(value, hashNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
