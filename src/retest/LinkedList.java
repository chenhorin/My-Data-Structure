package retest;

public class LinkedList<E> {
    private class Node {

        public E e;
        public Node next;

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        head = new Node(e);
    }

    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size,e);
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("参数越界");
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        E ret = prev.next.e;
        prev.next = prev.next.next;
        return ret;
    }
}
