package escuelaing.edu.co.BST;

import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> implements List<E> {

    private class Node {
        E value;
        Node left, right;

        Node(E value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    // Insertion
    public boolean add(E value) {
        root = insertRec(root, value);
        return true; // Assuming add always succeeds
    }

    private Node insertRec(Node root, E value) {
        if (root == null) {
            size++;
            return new Node(value);
        }
        if (value.compareTo(root.value) < 0) {
            root.left = insertRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    private Node searchRec(Node root, E value) {
        if (root == null || root.value.equals(value)) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            return searchRec(root.left, value);
        }
        return searchRec(root.right, value);
    }

    // Deletion
    public boolean remove(Object value) {
        if (contains(value)) {
            root = deleteRec(root, (E) value);
            size--;
            return true;
        }
        return false;
    }

    private Node deleteRec(Node root, E value) {
        if (root == null) {
            return root;
        }
        if (value.compareTo(root.value) < 0) {
            root.left = deleteRec(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children
            root.value = findMin(root.right).value;
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    // Find Minimum
    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Traversal
    public List<E> inOrderTraversal() {
        List<E> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    private void inOrderRec(Node root, List<E> result) {
        if (root != null) {
            inOrderRec(root.left, result);
            result.add(root.value);
            inOrderRec(root.right, result);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return inOrderTraversal().iterator();
    }

    @Override
    public Object[] toArray() {
        return inOrderTraversal().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return inOrderTraversal().toArray(a);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E value : c) {
            modified |= add(value);
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object value : c) {
            modified |= remove(value);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("retainAll not supported");
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return inOrderTraversal().get(index);
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("set not supported");
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("add at index not supported");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("remove at index not supported");
    }

    @Override
    public int indexOf(Object o) {
        List<E> elements = inOrderTraversal();
        return elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        List<E> elements = inOrderTraversal();
        return elements.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return inOrderTraversal().listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return inOrderTraversal().listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return inOrderTraversal().subList(fromIndex, toIndex);
    }

    // New methods implementation
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object value : c) {
            if (!contains(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        boolean modified = false;
        for (E value : c) {
            add(value);
            modified = true;
        }
        return modified;
    }
}
