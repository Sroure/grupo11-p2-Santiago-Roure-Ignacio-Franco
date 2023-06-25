package Test;
import Hash.MyHashImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashImplTest {
    @Test
    void TestHash(){
        MyHashImpl hash = new MyHashImpl(11);
        hash.insert(1, "hola");
        hash.insert(2, "chau");
        hash.insert(3, "adios");
        hash.insert(4, "hasta luego");
        hash.insert(5, "hasta mañana");
        hash.insert(6, "hasta nunca");
        hash.insert(7, "hasta siempre");
        hash.insert(8, "hasta la vista");
        hash.insert(9, "hasta la proxima");
        hash.insert(10, "hasta la victoria");

        assertEquals(true, hash.search(1));
        assertEquals(true, hash.search(2));
        assertEquals(true, hash.search(3));
        assertEquals(true, hash.search(4));
        assertEquals(true, hash.search(5));
        assertEquals(true, hash.search(6));
        assertEquals(true, hash.search(7));
        assertEquals(true, hash.search(8));
        assertEquals(true, hash.search(9));
        assertEquals(true, hash.search(10));
        hash.delete(1);
        hash.delete(2);
        hash.delete(3);
        hash.delete(4);
        hash.delete(5);
        hash.delete(6);
        hash.delete(7);
        hash.delete(8);
        hash.delete(9);
        hash.delete(10);
        hash.insert(11, "hola");
        assertEquals(false, hash.search(1));
        assertEquals(false, hash.search(2));
        assertEquals(true, hash.search(11));
        assertEquals("hola", hash.get(11));
        assertEquals(1, hash.ElementosEnhash());

    }
}