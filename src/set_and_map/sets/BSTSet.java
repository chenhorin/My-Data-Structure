package set_and_map.sets;

import binary_search_tree.BST;
import set_and_map.FileOperation;

import java.util.ArrayList;

public class BSTSet<E extends Comparable> implements Set<E> {

    private BST bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int size() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.size());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
        }
    }
}
