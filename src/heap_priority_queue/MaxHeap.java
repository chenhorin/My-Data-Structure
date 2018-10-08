package heap_priority_queue;

import arrays.Array;

import javax.swing.*;
import java.util.Date;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.getSize();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index -- 0, doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int i) {
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("data is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0,data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int i) {
        while (leftChild(i) < data.getSize()) {
            int j = leftChild(i);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(i).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(i, j);
            i = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
