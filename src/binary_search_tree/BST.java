package binary_search_tree;

public class BST<E extends Comparable<E>> {
    private class Node {
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

    /*public void add(E e) {
        if (root == null) {
            root = new Node(e);
//            注意加size
            size++;
        } else {
            add(root,e);
        }
    }*/
//常用算法
    /*public void add(Node *//*root注意命名*//*node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
//            需要中止,不需要再继续后面的判断了
            *//*return;*//*
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0)
            add(node.left,e);
        if (e.compareTo(node.e) > 0) {
            add(node.right,e);
        }
    }*/
//递归算法
    public void add(E e) {
        add(root,e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }


    private int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BST<String> bst = new BST<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            bst.add(res.toString());
        }

        return bst.getSize();
    }
}
