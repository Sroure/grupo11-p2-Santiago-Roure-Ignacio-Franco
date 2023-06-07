package Test;

import BinarySearchTree.BinarySearchTreeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void TestBinarySeachTree() {
        // Pruebas de binary search tree
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();
        tree.add(3, 3);
        assertEquals(1, tree.size());
        tree.add(21, 21);
        assertEquals(2, tree.size());
        tree.delete(3);
        assertEquals(1, tree.size());
        tree.add(11, 11);
        tree.add(-1, -1);
        tree.add(4, 4);
        assertEquals(4, tree.size());
        tree.add(18, 18);
        assertEquals(5, tree.size());
        tree.find(3);
    }
}