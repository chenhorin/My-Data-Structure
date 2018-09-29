package linkedlist;

import java.util.Currency;

public class LinkedList<E> {


    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
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
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail , index illegal");
        }
        /*if (index == 0) {
            addFirst(e);
        }*/
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;*/
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fail , index illegal");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail , index illegal");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
//        为什么需要释放?释放内存方便回收
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public void removeElement(E e) {
        removeElement(dummyHead,e);
    }

    private void removeElement(Node node, E e) {

        while (node.next != null) {
            Node cur = node.next;
            if (cur.e == e) {
                node.next = cur.next;
                cur = null;
                size--;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LinkedList : size = %d\n", size));
        res.append("head [");
        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.e);
            if (cur.next != null) {
                res.append("->");
            }
            cur = cur.next;
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        System.out.println(list);

        list.remove(6);
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        System.out.println(list.get(0));
    }
}
