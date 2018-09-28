package binary_search_tree;

public class BST {
    private class Node<E> {
        public E e;
        public Node left, right;

        public Node() {
            this.left = null;
            this.right = null;
        }

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
