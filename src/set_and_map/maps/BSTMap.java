package set_and_map.maps;

import set_and_map.FileOperation;

import java.util.ArrayList;

public class BSTMap <K extends Comparable<K>, V> implements Map<K , V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node left, Node right) {
            this(key, value);
            this.left = left;
            this.right = right;
        }

        public Node() {
        }
    }

    private Node root;

    private int size;


    public BSTMap(Node root) {
        this.root = root;
        this.size = 0;
    }

    public BSTMap() {
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
//        没有添加操作
        /*if (node == null) {
            return null;
        }*/
        if (node == null) {
            size++;
            return new Node(key, value);
        }
//        不需要return
        /*if (key.compareTo(node.key) < 0) {
            return node.left = add(node.left, key, value);
        }
        if (key.compareTo(node.key) > 0) {
            return node.right = add(node.right, key, value);
        }*/
//       漏掉了相等的情况
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        V ret = get(key);
        if (ret == null) {
            return null;
        }
        root = remove(root, key);
        return ret;
    }

    private Node remove(Node node, K key) {
//        总漏啊
        /*if (node == null) {
            return null;
        }
        if (node.left == null) {
            Node rightNode = node.right;
            size--;
            node.right = null;
            return rightNode;
        }
        if (node.right == null) {
            Node leftNode = node.left;
            size--;
            node.left = null;
            return leftNode;
        }
        if (key.equals(node.key)) {
            Node successor = maximum(node.right);
            successor.left = node.left;
            successor.right = removeMax(node.right);
            size++;

            node.right = node.left = null;
            size--;
            return successor;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        }
        return node;*/
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        }
        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        }

        /*else if (key.equals(node.key))*/
        else {
            if (node.left == null) {
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                size--;
                node.left = null;
                return leftNode;
            }
                Node successor = maximum(node.right);
                successor.left = node.left;
                successor.right = removeMax(node.right);
                size++;

                node.right = node.left = null;
                size--;
                return successor;
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    //都把root直接当入参传比较方便
    /*private Node removeMin() {
        if (minimum(root) == null) {
            return null;
        }
    }*/
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        return node.left = removeMin(node.left);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        return node.right = removeMax(node.right);
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
        return get(root, key) != null;
    }

    @Override
    public V get(K k) {
        /*if (root == null) {
            throw new IllegalArgumentException("map empty");
        }*/
        return get(root, k) == null ? null : get(root, k).value;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }
//        这样判断还是不行
        /*if (key.equals(node.key)) {
            return node;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = get(node.left, key);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = get(node.right, key);
        }
        return node;*/
//        改了之后也不行~~~~
        /*if (key.equals(node.key)) {
            return node;
        }
        else if (key.compareTo(node.key) < 0) {
            node.left = get(node.left, key);
        }
        else if (key.compareTo(node.key) > 0) {
            node.right = get(node.right, key);
        }
        return node;*/
        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return get(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return get(node.right, key);
    }

    @Override
    public void set(K key, V newValue) {
        Node node = get(root, key);
        if (node == null) {
            throw new IllegalArgumentException("没有此key");
        }
//        add(key, newValue);
        // 通过指针修改set的值
        node.value = newValue;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}