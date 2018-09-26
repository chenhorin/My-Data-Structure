package stack_and_queue;

public interface Queue<E> {

    boolean isEmpty();

    int getSize();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
