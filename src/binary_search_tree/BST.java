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

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        /*if (node.e == e) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            contains(node.right, e);
        }*/
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //    前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        System.out.println(node.e);
        preOrder(node.right);
    }


    // 二分搜索树的中序遍历
    public void postOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

//leetcode题目测试
    /*private int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        BST<String> bst = new BST<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            bst.add(res.toString());
        }

        return bst.getSize();
    }*/

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
