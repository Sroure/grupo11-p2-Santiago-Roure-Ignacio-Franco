package Hash;


public class MyHashImpl<K,V> implements MyHash<K,V> {
    private HashNode[] hashTable;
    private int size;// capacidad del hash
    // no confundir con elementos en el hash, son cosas distintas
    // el size puede incluir elementos borrados

    public MyHashImpl(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size tiene que ser mayor a 0");
        this.size = size;// capacidad del hash
        this.hashTable = new HashNode[size];
        fillHashTableNull(hashTable);
    }

    private int HashFunction(K key) {
        return key.hashCode() % size;
    }
    private int linearCollision(int i){
        return i+1;
    }
    @Override
    public int elementosEnTabla() {// estos son los elementos que hay en el hash
        int contador = 0;// todos los elementos que no esten borrados o que no sean null
        for (int i = 0; i< size;i++){
            if (hashTable[i] != null && !hashTable[i].isDeleted()){
                contador++;
            }
        }
        return contador;
    }
    @Override
    public void insert(K key, V value) {
        int index = HashFunction(key);
        if (index < 0) {index = index * (-1);}// para que no de negativo
        HashNode<K, V> node = new HashNode<>(key, value);
        if (hashTable[index] == null || hashTable[index].isDeleted()) {
            hashTable[index] = node;
        }else{
            int i = 1;
            int newPosition = ((key.hashCode() + linearCollision(i)) % size);
            while(hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && i <= size){
                if (hashTable[newPosition].getKey().equals(key)){
                    hashTable[newPosition].setValue(value);
                    return;
                }
                i++;
                newPosition = ((key.hashCode() + linearCollision(i)) % size);
            }
            if (i > size){
                doubleSize();
            }
            if (hashTable[newPosition] == null || hashTable[newPosition].isDeleted()){
                hashTable[newPosition] = node;
            } else{
                this.insert(key, value);
            }
        }
    }
    private void doubleSize(){
        size *= 2;
        HashNode[] oldHashTable = hashTable;
        hashTable = new HashNode[size];
        fillHashTableNull(hashTable);
        for (int i = 0; i < oldHashTable.length; i++) {
            if (oldHashTable[i] != null && !oldHashTable[i].isDeleted()){
                this.insert((K) oldHashTable[i].getKey(), (V) oldHashTable[i].getValue());
            }
        }
    }


    @Override
    public void delete(K key) {
        int lugar = key.hashCode() % size;
        if (hashTable[lugar] != null && hashTable[lugar].getKey().equals(key)) {
            hashTable[lugar].setDeleted(true);
        } else {
            int i = 1;
            int newPosition = ((key.hashCode() + linearCollision(i)) % size);
            while (hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key) && i <= size) {
                i++;
                newPosition = ((key.hashCode() + linearCollision(i)) % size);
            }
            if (i <= size) {
                hashTable[newPosition].setDeleted(true);
            }
        }


    }

    @Override
    public boolean search(K key) {// este metodo lo que haces es que busca el elemento por la key y si lo encuentra devuelve true
        int index = key.hashCode() % size;
        int i = 1;
        if(hashTable[index] == null){
            return false;
        }
        else
        if(hashTable[index].getKey().equals(key)){
            if(hashTable[index].isDeleted()){
                return false;
            }
            else {
                return true;
            }
        }
        else{
            int newPosition = ((key.hashCode() + linearCollision(i)) % size);
            while (i <= size && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearCollision(i)) % size);
            }
            if (i <= size && hashTable[newPosition] != null && hashTable[newPosition].getKey().equals(key) && !hashTable[newPosition].isDeleted()) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public V get(K key) {
        int lugar = key.hashCode() % size;
        int i = 1;

        if(hashTable[lugar] == null){
            return null;
        }
        else
        if(hashTable[lugar].getKey().equals(key)){
            if(hashTable[lugar].isDeleted()){
                return null;
            }
            else {
                return (V) hashTable[lugar].getValue();
            }
        }
        else {
            int newPosition = ((key.hashCode() + linearCollision(i)) % size);
            while (i <= size && hashTable[newPosition] != null && !hashTable[newPosition].isDeleted() && !hashTable[newPosition].getKey().equals(key)) {
                i++;
                newPosition = ((key.hashCode() + linearCollision(i)) % size);
            }
            if (hashTable[newPosition] == null || hashTable[newPosition].isDeleted()) {
                return null;
            }

            return (V) hashTable[newPosition].getValue();
        }
    }
    public void fillHashTableNull(HashNode[] hashTable){
        for (int i = 0; i < size; i++) {
            hashTable[i] = null;
        }
    }

}
