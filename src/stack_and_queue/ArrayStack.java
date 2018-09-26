package stack_and_queue;

import arrays.Array;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> data;

    //需要初始化

    public ArrayStack() {
        data = new Array();
    }

    public ArrayStack(int capacity) {
        data = new Array(capacity);
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
    public E pop() {
        return data.removeLast();
    }

    @Override
    public void push(E e) {
        data.addLast(e);
    }

    @Override
    public E peek() {
        return data.get(this.getSize() - 1);
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
}
