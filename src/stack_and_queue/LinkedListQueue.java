package stack_and_queue;

import linkedlist.LinkedList;

public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> data;

    private int size;

    public LinkedListQueue() {
        data = new LinkedList();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Stack : Size = %d \n", getSize()));
        res.append("Front: [");
        for (int i = 0; i < getSize(); i++) {
            res.append(data.get(i));
            if (i != getSize() - 1) {
                res.append(" <- ");
            }
        }
        res.append("] <----tail");
        return res.toString();
    }
}
