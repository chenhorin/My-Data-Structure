package stack_and_queue;

public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    E pop(E e);

    void push(E e);

    E peek();
}
