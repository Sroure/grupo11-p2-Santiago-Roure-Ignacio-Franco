package Heap;

public interface MyHeap <T extends Comparable<T>>{
    T delete();
    T get();
    void insert(T element);
    int size();
    T getMin();
    T getMax();
}
