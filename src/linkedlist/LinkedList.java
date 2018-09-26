package linkedlist;

public class LinkedList<E> {
    private class Node<E> {
        private Node next;
        private E e;

        public Node(E e,Node next) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
//链表的添加因为没有索引,就需要addfirst,addlast
    /*public void addFirst(E e) {
        Node node = new Node(e);
        if (head == null) {
            head = node;
            size++;
            return;
        }

        head.next = node;
        head = node;
    }*/
    public void addFirst(E e) {
        head = new Node(e, head);
        size++;
    }

    public void addLast(E e) {
        add(size,e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界");
        }
        if (index == 0) {
            addFirst(e);
        }
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e, prev.next);
        size++;
    }
}
