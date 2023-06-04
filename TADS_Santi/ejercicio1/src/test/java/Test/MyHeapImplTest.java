package Test;
import Heap.MyHeapImpl;
import Heap.MyHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapImplTest {
    @Test
    void TestHeap(){
        MyHeapImpl heap = new MyHeapImpl(11);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(10);
        heap.insert(11);
        heap.size();
        assertEquals(11, heap.size());
        assertEquals(1, heap.getMin());
        assertEquals(11, heap.getMax());
        assertEquals(1, heap.delete());
    }
}