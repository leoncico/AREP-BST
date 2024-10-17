package escuelaing.edu.co.BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testAddAndInOrderTraversal() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 7);
        assertEquals(expected, bst.inOrderTraversal());
    }

    @Test
    void testContains() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        
        assertTrue(bst.contains(3));
        assertTrue(bst.contains(5));
        assertFalse(bst.contains(10));
    }

    @Test
    void testRemoveLeafNode() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.remove(3);
        
        List<Integer> expected = Arrays.asList(5, 7);
        assertEquals(expected, bst.inOrderTraversal());
    }

    @Test
    void testRemoveNodeWithOneChild() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(6);
        bst.remove(7);
        
        List<Integer> expected = Arrays.asList(3, 5, 6);
        assertEquals(expected, bst.inOrderTraversal());
    }

    @Test
    void testRemoveNodeWithTwoChildren() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(6);
        bst.add(8);
        bst.remove(7);
        
        List<Integer> expected = Arrays.asList(3, 5, 6, 8);
        assertEquals(expected, bst.inOrderTraversal());
    }

    @Test
    void testSize() {
        bst.add(5);
        bst.add(3);
        bst.add(7);
        assertEquals(3, bst.size());
        
        bst.remove(3);
        assertEquals(2, bst.size());
    }

    @Test
    void testClear() {
        bst.add(5);
        bst.add(3);
        bst.clear();
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
    }

    @Test
    void testContainsAll() {
        bst.add(1);
        bst.add(2);
        bst.add(3);
        
        List<Integer> checkList = Arrays.asList(1, 2);
        assertTrue(bst.containsAll(checkList));
        
        checkList = Arrays.asList(1, 4);
        assertFalse(bst.containsAll(checkList));
    }

    @Test
    void testAddAll() {
        bst.addAll(Arrays.asList(5, 3, 7));
        
        List<Integer> expected = Arrays.asList(3, 5, 7);
        assertEquals(expected, bst.inOrderTraversal());
    }

    @Test
    void testAddAllWithIndex() {
        bst.add(5);
        bst.add(7);
        bst.addAll(1, Arrays.asList(6, 4));

        List<Integer> expected = Arrays.asList(4, 5, 6, 7);
        assertEquals(expected, bst.inOrderTraversal());
    }
}
