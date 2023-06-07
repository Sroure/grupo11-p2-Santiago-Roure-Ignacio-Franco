package Heap;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T>{
    private static final int CAPACITY = 2;
    private int size; // Number of elements in heap
    private T[] heap; // The heap array
    private boolean isHeapMin = true;

    public MyHeapImpl(boolean isHeapMin) {
        this.size = 0;
        this.heap = (T[]) new Comparable[CAPACITY];
        this.isHeapMin = isHeapMin;

    }
    public MyHeapImpl(int capacity) {this(capacity, true);}
    public MyHeapImpl(int capacity, boolean isHeapMin) {
        this.size = 0;
        this.heap = (T[]) new Comparable[capacity + 1];
        this.isHeapMin = isHeapMin;
    }
    public MyHeapImpl(T[] array) {this(array, true);}

    public MyHeapImpl(T[] array, boolean isHeapMin) {
        this.isHeapMin = isHeapMin;
        this.size = array.length;
        this.heap = (T[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0 index
        buildHeap();
    }

    private void buildHeap(){
        for (int k = size / 2;k>0;k-- ){
            percolatingDown(k);
        }
    }
    public void percolatingDown(int k){ // esta operacion lo que haces es cuando se elimina un elemento del heap, se reordena el heap
        T tmp = heap[k];
        int child;
        for (;2*k<=size;k=child){
            child = 2*k;
            if (child != size && heap[child+1].compareTo(heap[child])<0){
                child++;
            }
            if (tmp.compareTo(heap[child])>0){
                heap[k] = heap[child];
            }else{
                break;
            }
        }
    }
    @Override
    public T delete() throws RuntimeException{
        if (size == 0){
            throw new RuntimeException();
        }
        T min = heap[1];
        heap[1] = heap[size--];
        percolatingDown(1);
        return min;

    }

    @Override
    public T get() {
        if (size == 0){
            throw new RuntimeException();
        }
        T min = heap[1];
        return min;
    }

    @Override
    public void insert(T element) {
        if (size == heap.length-1){
            doubleSize();
        }
        int pos = ++size;
        for (;pos>1 && element.compareTo(heap[pos/2])<0;pos/=2){
            heap[pos] = heap[pos/2];
        }
        heap[pos] = element;
    }
    public void doubleSize(){
        T[] old = heap;
        heap = (T[]) new Comparable[heap.length*2];
        System.arraycopy(old,1,heap,1,size);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public T getMin() {
        if (isHeapMin){
            return get();
        }else{
            return getMax();
        }
    }
    @Override
    public T getMax() {
        if (isHeapMin){
            return heap[size];
        }else{
            return get();
        }
    }
}
