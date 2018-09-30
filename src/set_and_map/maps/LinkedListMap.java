package set_and_map.maps;

import set_and_map.FileOperation;

import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this(key, value);
            this.next = next;
            /*this.value = null;*/
            this.value = value;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
        @Override
        public String toString(){
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;

    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node  = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        } else {
            node.value = value;
        }
    }

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while(cur != null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        /*Node prev = dummyHead;
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("can't find");
        }
        while (prev.next != node) {
            prev = prev.next;
        }
        prev.next = node.next;
        node.next = null;*/
//        时间复杂度要高一些
        Node prev = dummyHead;
        V ret = null;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                ret = prev.next.value;
                Node delNode = prev.next;
                prev.next = delNode.next;
                size--;
                delNode.next = null;
            }
            prev = prev.next;
        }
        return ret;
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
    public boolean contains(K key) {
        /*return get(key) == null ? false : true;*/
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    /*private Node get(Node node, K key) {
        *//*if (node == null) {
            throw new IllegalArgumentException("map为空");
        }*//*
        if (node.next == null) {
            return null;
        }
        if (node.key == key) {
            return node;
        }
        node = get(node.next, key);
        return node;
    }*/

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        /*if (node == null) {
            return;
        }*/
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println();
            System.out.println("Frequency of PRIDE: " + map.remove("pride"));
            System.out.println("Total different words: " + map.size());
        }

        System.out.println();
    }
}
