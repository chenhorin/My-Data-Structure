package stack_and_queue;

import linkedlist.LinkedList;

public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> data;
//  通过子类返回不需要这个字段
    /*private int size;*/

    public LinkedListStack() {
        data = new LinkedList();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        /*res.append(String.format("ArrayStack : "))不需要再像数组一样要求*/
        res.append("Stack :\n");
        res.append("[");
        /* res.append(data.toString());这是返回数组的具体格式,所以不匹配*/
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1)
                res.append(" , ");
        }
        /*res.append("]");还需要加top*/
        res.append("] top");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> listStack = new LinkedListStack<>();

        for (int i = 0; i < 122; i++) {
            listStack.push(i);
        }
        System.out.println(listStack);
        for (int i = 0; i < 121; i++) {
            listStack.pop();
        }
        System.out.println(listStack);
    }
}
